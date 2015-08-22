import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class WordTest {

  @Test
  public void Word_instantiatesCorrectly_true() {
    Word myWord = new Word("derelict");
    assertEquals(true, myWord instanceof Word);
  }

  @Test
  public void word_instantiatesWithDefinition_true() {
    Word myWord = new Word("derelict");
    assertEquals("derelict", myWord.getDefinition());
  }

  @Test
    public void isCompleted_isFalseAfterInstantiaon_false() {
      Word myWord = new Word("derelict");
      assertEquals(false, myWord.isCompleted());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() {
      Word myWord = new Word("derelict");
      assertEquals(LocalDateTime.now().getDayOfWeek(), myWord.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void all_returnsAllInstancesOfWord_true() {
      Word firstWord = new Word("derelict");
      Word secondWord = new Word("waffles");
      assertTrue(Word.all().contains(firstWord));
      assertTrue(Word.all().contains(secondWord));
    }

    @Test
    public void newId_wordInstantiateWithAnID_true() {
      Word myWord = new Word("derelict");
      assertEquals(Word.all().size(), myWord.getId());
    }

    @Test
    public void find_returnsWordWithSameId_secondWord() {
      Word first = new Word("derelict");
      Word secondTask = new Task("waffles");
      assertEquals(Word.find(secondWord.getId()), secondWord);
    }

    @Test
    public void find_returnsNullWhenNoWordFound_null() {
      assertTrue(Word.find(999) == null);
    }

    @Test
    public void clear_emptiesAllWordsFromArrayList() {
      Word myWord = new Word("derelict");
      Word.clear();
      assertEquals(Word.all().size(), 0);
    }

 }
