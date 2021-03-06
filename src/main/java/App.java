import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("words", request.session().attribute("words"));
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("words", Word.all());
    model.put("template", "templates/words.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  get("words/new", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    model.put("template", "templates/word-form.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/words", (request, response) -> {
    HashMap<String, Object> model = new HashMap<String, Object>();
    String description = request.queryParams("description");
    Word newWord = new Word(description);
    model.put("template", "templates/success.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

 get("/words/:id", (request, response) -> {
   HashMap<String, Object> model = new HashMap<String, Object>();

   Word word = Word.find(Integer.parseInt(request.params(":id")));
   model.put("word", word);
   model.put("template", "templates/word.vtl");
   return new ModelAndView(model, layout);
 }, new VelocityTemplateEngine());
}
}
