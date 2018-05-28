package co.edu.eafit.dis.st0270.s20181.rafacort;

import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

/**
 * TigerMain by Rafael VIllegas and Felipe Cortes
 */
public class TigerMain {

  public static void usage() {
    System.err.println("Usage: TigerMain [-s] [-p] <Files>...");
  }

  public static void main(String[] args) {

    int argsNum = args.length;

    if(args[0].equals("-s")) {
      
      if(args[1].equals("-p")) {

        if(args[2].contains(".tgr")) {

          for(int i = 2; i < argsNum; i++) {

            try {
              TigerLexer scan = new TigerLexer(new FileReader(args[i]));
              TigerParser parser = new TigerParser(scan);
              // print the token stream
              parser.debug_parse();
              System.out.println("File: " + args[i] + " Parser: " + parser.parse().value);
            }
            catch(FileNotFoundException fnfe) {
              usage();
            }
            catch(Exception e) {
              System.err.println(e);
              System.exit(1);
            }
    
          }
        }
        else {
          usage();
        }

      }
      else if(args[1].contains(".tgr")) {

        for(int i = 1; i < argsNum; i++) {

          try {
            TigerLexer scan = new TigerLexer(new FileReader(args[i]));
            TigerParser parser = new TigerParser(scan);
            // print the token stream
            parser.debug_parse();
          }
          catch(FileNotFoundException fnfe) {
            usage();
          }
          catch(Exception e) {
            System.err.println(e);
            System.exit(1);
          }
  
        }
      }
      else {
        usage();
      }

    }
    else if(args[0].equals("-p")) {

      if(args[1].equals("-s")) {

        if(args[2].contains(".tgr")) {
          
          for(int i = 2; i < argsNum; i++) {

            try {
              TigerLexer scan = new TigerLexer(new FileReader(args[i]));
              TigerParser parser = new TigerParser(scan);
              // print the token stream
              parser.debug_parse();
              System.out.println("File: " + args[i] + " Parser: " + parser.parse().value);
            }
            catch(FileNotFoundException fnfe) {
              usage();
            }
            catch(Exception e) {
              System.err.println(e);
              System.exit(1);
            }
    
          }
  
        }
        else {
          usage();
        }

      }
      else if(args[1].contains(".tgr")) {

        for(int i = 1; i < argsNum; i++) {

          try {
            TigerLexer scan = new TigerLexer(new FileReader(args[i]));
            TigerParser parser = new TigerParser(scan);
            System.out.println("File: " + args[i] + " Parser: " + parser.parse().value);
          }
          catch(FileNotFoundException fnfe) {
            usage();
          }
          catch(Exception e) {
            System.err.println(e);
            System.exit(1);
          }
  
        }

      }
      else {
        usage();
      }
    }
    else if(args[0].contains(".tgr")) {

      for(int i = 0; i < argsNum; i++) {

        try {
          TigerLexer scan = new TigerLexer(new FileReader(args[i]));
          TigerParser parser = new TigerParser(scan);
          System.out.println("File: " + args[i] + " Parser: " + parser.parse().value);
        }
        catch(FileNotFoundException fnfe) {
          usage();
        }
        catch(Exception e) {
          System.err.println(e);
	        System.exit(1);
        }

      }

    }
    else {
      usage();
    }

  }
  
}