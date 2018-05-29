package co.edu.eafit.dis.st0270.s20181.rafacort;

import java_cup.runtime.*;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;

import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


/**
 * TigerMain by Rafael VIllegas and Felipe Cortes
 */
public class TigerMain {

  public static void usage() {
    System.err.println("Usage: TigerMain [-s] [-p] <Files>...");
  }

  public static void main(String[] args) {

    Set<String> keyWords = new HashSet<>(Arrays.asList(
                                                        "ARRAY", "IF", "THEN", "ELSE", "WHILE", "OR", "TO", "DO", "LET", "IN", 
                                                        "END", "OF", "BREAK", "NIL", "FUNCTION", "VAR", "TYPE", "IMPORT",
                                                        "PRIMITIVE", "CLASS", "EXTENDS", "METHOD", "NEW"
                                                      ));
    
    Set<String> signs = new HashSet<>(Arrays.asList(
                                                      "POINT", "COLON", "SEMICOLON", "LPAREN", "RPAREN", "LCOR", "RCOR", "LKEY", "RKEY", "IN", 
                                                      "COMMA", "ADD", "SUB", "TIMES", "DIV", "EQUALS", "DIFFERENT", "LESSTHAN",
                                                      "LESSEQUAL", "MORETHAN", "MOREEQUAL", "AND", "OR", "PRODUCE"
                                                    ));

    int argsNum = args.length;

    if(args[0].equals("-s")) {
      
      if(args[1].equals("-p")) {

        if(args[2].contains(".tgr")) {

          for(int i = 2; i < argsNum; i++) {

            try {
              TigerLexer scan = new TigerLexer(new FileReader(args[i]));
              TigerParser parser = new TigerParser(scan);
              // print the token stream
              Symbol token = scan.next_token();
              // print the token stream
              while(!TigerSymbols.terminalNames[token.sym].equals("EOF")) {
                System.out.println(
                                    "[" + scan.getLine() + 
                                    ", " + scan.getColumn() + 
                                    ", " + getType(TigerSymbols.terminalNames[token.sym], keyWords, signs) + 
                                    ", " + scan.getText() + "]"  
                                  );
                token = scan.next_token();
              }
              System.out.println("File: " + args[i] + " Parser: True");
            }
            catch(FileNotFoundException fnfe) {
              usage();
            }
            catch(Exception e) {
              System.out.println("File: " + args[i] + " Parser: False");
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
            Symbol token = scan.next_token();
              // print the token stream
              while(!TigerSymbols.terminalNames[token.sym].equals("EOF")) {
                System.out.println(
                                    "[" + scan.getLine() + 
                                    ", " + scan.getColumn() + 
                                    ", " + getType(TigerSymbols.terminalNames[token.sym], keyWords, signs) + 
                                    ", " + scan.getText() + "]"
                                  );
                token = scan.next_token();
              }
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
              Symbol token = scan.next_token();
              // print the token stream
              while(!TigerSymbols.terminalNames[token.sym].equals("EOF")) {
                System.out.println(
                                    "[" + scan.getLine() + 
                                    ", " + scan.getColumn() + 
                                    ", " + getType(TigerSymbols.terminalNames[token.sym], keyWords, signs) + 
                                    ", " + scan.getText() + "]"
                                  );
                token = scan.next_token();
              }
              System.out.println("File: " + args[i] + " Parser: True");
            }
            catch(FileNotFoundException fnfe) {
              usage();
            }
            catch(Exception e) {
              System.out.println("File: " + args[i] + " Parser: False");
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
            System.out.println("File: " + args[i] + " Parser: True");
          }
          catch(FileNotFoundException fnfe) {
            usage();
          }
          catch(Exception e) {
            System.out.println("File: " + args[i] + " Parser: False");
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
          System.out.println("File: " + args[i] + " Parser: True");
        }
        catch(FileNotFoundException fnfe) {
          usage();
        }
        catch(Exception e) {
          System.out.println("File: " + args[i] + " Parser: False");
	        System.exit(1);
        }

      }

    }
    else {
      usage();
    }

  }

  private static String getType(String token, Set<String> keywords, Set<String> signs) {
    if(token.equals("INTEGER")) {
      return "number";
    }
    else if(token.equals("STRING")) {
      return "string";
    }
    else if(keywords.contains(token)) {
      return "keyword";
    }
    else if(signs.contains(token)) {
      return "symbol";
    }
    else {
      return "error";
    }
  }
  
}