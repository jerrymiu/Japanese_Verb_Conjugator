import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.regex.Pattern;

import static spark.Spark.*;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    get("/hello", (req, res) -> "Hello World");

    get("/", (request, response) -> {
         Date date = new Date();

        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", date.toString());

        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());

     get("/result", (request, response) -> {
      Date date = new Date();
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("message", date.toString());

        return new ModelAndView(attributes, "index.ftl");
    }, new FreeMarkerEngine());

    post("/result", (request, response) -> {
    String rawverb;
    rawverb= request.queryParams("rawverb");
     Map<String, Object> attributes = new HashMap<>();
   
    if (rawverb.matches("\\A\\p{ASCII}*\\z"))
    {
      rawverb ="食べる";
      attributes.put("message", "No valid verb supplied, so example used is 食べる");

    }else
    {
      attributes.put("message", "");
    }

   
      int verblength = rawverb.length();
        
        //Plain Forms
        attributes.put("Positive_Plain_Form", rawverb);
        String stem = rawverb.substring(0, verblength - 1);
        attributes.put("Verb_Stem", stem);
        String Negative_Plain_Form = stem + "ない";
        attributes.put("Negative_Plain_Form", Negative_Plain_Form);
        
        //Volitional Plain Form
        String Positive_Volitional_Form = stem + "よう";
        attributes.put("Positive_Volitional_Form", Positive_Volitional_Form);
        String Negative_Volitional_Form = stem + "ないだろう";
        attributes.put("Negative_Volitional_Form", Negative_Volitional_Form);
  
        //Volitional Polite Form
        String Positive_Volitional_Polite_Form = stem + "ましょう";
        attributes.put("Positive_Volitional_Polite_Form", Positive_Volitional_Polite_Form);
        String Negative_Volitional_Polite_Form = stem + "ないでしょう";
        attributes.put("Negative_Volitional_Polite_Form", Negative_Volitional_Polite_Form);
  
        //Polite forms
        String Positive_Polite_Form = stem + "ます";
        attributes.put("Positive_Polite_Form", Positive_Polite_Form);
        String Negative_Polite_Form = stem + "ません";
        attributes.put("Negative_Polite_Form", Negative_Polite_Form);

        
        //Imperative Plain forms
         String Positive_Plain_Imperative_Form = stem + "ろ";
        attributes.put("Positive_Plain_Imperative_Form", Positive_Plain_Imperative_Form);
        String Negative_Plain_Imperative_Form = stem + "るな";
        attributes.put("Negative_Plain_Imperative_Form", Negative_Plain_Imperative_Form);


         //Imperative Polite forms
        String Positive_Polite_Imperative_Form = stem + "てください";
        attributes.put("Positive_Polite_Imperative_Form", Positive_Polite_Imperative_Form);
        String Negative_Polite_Imperative_Form = stem + "ないでください";
        attributes.put("Negative_Polite_Imperative_Form", Negative_Polite_Imperative_Form);

        //Past Plain forms
        String Positive_Plain_Past_Form = stem + "た";
        attributes.put("Positive_Plain_Past_Form", Positive_Plain_Past_Form);
        String Negative_Plain_Past_Form = stem + "なかった";
        attributes.put("Negative_Plain_Past_Form", Negative_Plain_Past_Form);

         //Past Polite forms
        String Positive_Polite_Past_Form = stem + "ました";
        attributes.put("Positive_Polite_Past_Form", Positive_Polite_Past_Form);
        String Negative_Polite_Past_Form = stem + "ませんでした";
        attributes.put("Negative_Polite_Past_Form", Negative_Polite_Past_Form);
        

        //Conditional Plain forms
        String Positive_Plain_Conditional_Form = stem + "たら";
        attributes.put("Positive_Plain_Conditional_Form", Positive_Plain_Conditional_Form);
        String Negative_Plain_Conditional_Form = stem + "なかったら";
        attributes.put("Negative_Plain_Conditional_Form", Negative_Plain_Conditional_Form);

         //Conditional Polite forms
        String Positive_Polite_Conditional_Form = stem + "ましたら";
        attributes.put("Positive_Polite_Conditional_Form", Positive_Polite_Conditional_Form);
        String Negative_Polite_Conditional_Form = stem + "ませんでしたら";
        attributes.put("Negative_Polite_Conditional_Form", Negative_Polite_Conditional_Form);
        

        //Progressive Plain forms
        String Positive_Plain_Progressive_Form = stem + "ている";
        attributes.put("Positive_Plain_Progressive_Form", Positive_Plain_Progressive_Form);
        String Negative_Plain_Progressive_Form = "n/a";
        attributes.put("Negative_Plain_Progressive_Form", Negative_Plain_Progressive_Form);

         //Progressive Polite forms
        String Positive_Polite_Progressive_Form = stem + "ています";
        attributes.put("Positive_Polite_Progressive_Form", Positive_Polite_Progressive_Form);
        String Negative_Polite_Progressive_Form = stem + "ていません";
        attributes.put("Negative_Polite_Progressive_Form", Negative_Polite_Progressive_Form);
        


        return new ModelAndView(attributes, "result.ftl");
    }, new FreeMarkerEngine());




    HikariConfig config = new  HikariConfig();
    config.setJdbcUrl(System.getenv("JDBC_DATABASE_URL"));
    final HikariDataSource dataSource = (config.getJdbcUrl() != null) ?
      new HikariDataSource(config) : new HikariDataSource();

    get("/db", (req, res) -> {
      Map<String, Object> attributes = new HashMap<>();
      try(Connection connection = dataSource.getConnection()) {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      }
    }, new FreeMarkerEngine());

  }

}
