

package com.iluwatar.event.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Testing the Audio service of the Queue
 * @author mkuprivecz
 *
 */
public class AudioTest {

  private Audio audio;

  @BeforeEach
  void createAudioInstance() {
    audio = new Audio();
  }
  /**
   * Test here that the playSound method works correctly
   * @throws UnsupportedAudioFileException when the audio file is not supported 
   * @throws IOException when the file is not readable
   * @throws InterruptedException when the test is interrupted externally
   */
  @Test
  public void testPlaySound() throws UnsupportedAudioFileException, IOException, InterruptedException {
    audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.wav"), -10.0f);
    // test that service is started
    assertTrue(audio.isServiceRunning());
    // adding a small pause to be sure that the sound is ended
    Thread.sleep(5000);

    audio.stopService();
    // test that service is finished
    assertFalse(audio.isServiceRunning());
  }

  /**
   * Test here that the Queue
   * @throws UnsupportedAudioFileException when the audio file is not supported 
   * @throws IOException when the file is not readable
   * @throws InterruptedException when the test is interrupted externally
   */
  @Test
  public void testQueue() throws UnsupportedAudioFileException, IOException, InterruptedException {
    audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.aif"), -10.0f);
    audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.aif"), -10.0f);
    audio.playSound(audio.getAudioStream("./etc/Bass-Drum-1.aif"), -10.0f);
    assertTrue(audio.getPendingAudio().length > 0);
    // test that service is started
    assertTrue(audio.isServiceRunning());
    // adding a small pause to be sure that the sound is ended
    Thread.sleep(10000);

    audio.stopService();
    // test that service is finished
    assertFalse(audio.isServiceRunning());
  }

}
