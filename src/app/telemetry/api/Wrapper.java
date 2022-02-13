package app.telemetry.api;

import app.telemetry.API;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Wrapper implements API {


  @Override
  public String run() throws IOException {  
    Scanner sc = new Scanner(returnLink().openStream());

    StringBuilder sb = new StringBuilder();
    while (sc.hasNextLine()) {
      sb.append(sc.nextLine()).append("\n");
    }
    sc.close();
    return sb.toString();
  }

  @Override
  public URL returnLink() throws IOException {
    return new URL("https://exoad.github.io/MusicPlayer4J/api/version");
  }
  
}
