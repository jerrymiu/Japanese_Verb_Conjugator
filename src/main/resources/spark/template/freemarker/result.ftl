<!DOCTYPE html>
<html>
<head>
  <#include "header.ftl">
</head>

<body>

  <#include "nav.ftl">

<div class="jumbotron text-center">
  <div class="container">
    <a href="/" class="lang-logo">
      <img src="/lang-logo.png">
    </a>
    <h1>Japanese Verb Conjugator</h1>
    <h2>By: Jerry Miu</h2>
    <p>This is a simple Japanese verb conjugator deployed to Heroku. Written in Java, using the Spark Framework.</p>
    <a type="button" class="btn btn-lg btn-primary" href="https://github.com/jerrymiu/Japanese_Verb_Conjugator"><span class="glyphicon glyphicon-download"></span> Source on GitHub</a>
  </div>
</div>
<div class="container">
  
  <hr>
  <div class="row">
  
    <div class="col-md-12">
      <h3><span class="glyphicon glyphicon-link"></span> Conjugator</h3>
      <p>Expected input is of the basic dictionary form, e.g. 見る、考える、食べる、着る</p>
      <p><b>${message}</b></p>
      <br>
      <table>
        <tr>
          <th>Conjugation Name</th>
          <th id = "positive">Positive</th>
          <th id = "negative">Negative</th>
          <th>Explanation</th>
        </tr>
        <tr>
          <td>Verb Stem</td>
          <td>${Verb_Stem}</td>
          <td>n/a</td>
          <td>The verb stem is a morpheme used as a base to add inflectional endings.</td>
        </tr>
        <tr>
          <td> Present Plain Form</td>
          <td>${Positive_Plain_Form}</td>
          <td>${Negative_Plain_Form}</td>
          <td>The indicative mood is for statements of fact. The present tense is used for actions that may be habitual as well as for future actions. This form does not show any special respect for the listener, thus it is suitable for use among casual friends.<p>
        </tr>
         <tr>
          <td> Present Polite Form</td>
          <td>${Positive_Polite_Form}</td>
          <td>${Negative_Polite_Form}</td>
          <td>The indicative mood is for statements of fact. The present tense is used for actions that may be habitual as well as for future actions. This form shows respect for the listener and it suitable for use with strangers and acquaintances.<p>
        </tr>

      
        <tr>
          <td> Volitional Plain Form</td>
          <td>${Positive_Volitional_Form}</td>
          <td>${Negative_Volitional_Form}</td>
           <td>Usually used to express probability, belief, intention, or desire. It can also be translated as "Lets...". This form does not show any special respect for the listener.</td>
        </tr>
        <tr>
          <td> Volitional Polite Form</td>
          <td>${Positive_Volitional_Polite_Form}</td>
          <td>${Negative_Volitional_Polite_Form}</td>
          <td>Usually used to express probability, belief, intention, or desire. It can also be translated as "Lets...". This form shows respect for the listener.</td>
        </tr>
       <tr>
          <td> Imperative Plain Form</td>
          <td>${Positive_Plain_Imperative_Form}</td>
          <td>${Negative_Plain_Imperative_Form}</td>
          <td>Used to express a forceful command.</td>
        </tr>
        <tr>
          <td> Imperative Polite Form</td>
          <td>${Positive_Polite_Imperative_Form}</td>
          <td>${Negative_Polite_Imperative_Form}</td>
          <td>Used to express a soft request with respect</td>
        </tr>
        <tr>
          <td>Progressive Plain Form</td>
          <td>${Positive_Plain_Progressive_Form}</td>
          <td>${Negative_Plain_Progressive_Form}</td>
          <td>Used to express an ongoing action or state of being. This form does not show politeness to listener.</td>
        </tr>
        <tr>
          <td>Progressive Polite Form</td>
          <td>${Positive_Polite_Progressive_Form}</td>
          <td>${Negative_Polite_Progressive_Form}</td>
          <td>Used to politely express an ongoing action or state of being.</td>
        </tr>

        <tr>
          <td> Past Plain Form</td>
          <td>${Positive_Plain_Past_Form}</td>
          <td>${Negative_Plain_Past_Form}</td>
          <td>Used to describe actions that have been completed in the past.</td>
        </tr>
         <tr>
          <td> Past Polite Form</td>
          <td>${Positive_Polite_Past_Form}</td>
          <td>${Negative_Polite_Past_Form}</td>
          <td>Used to politely describe actions that have been completed in the past.</td>
        </tr>
          <tr>
          <td> Past Conditional Form</td>
          <td>${Positive_Plain_Conditional_Form}</td>
          <td>${Negative_Plain_Conditional_Form}</td>
          <td>Used for various "if" meanings, past occurence, hypothesis etc.</td>
        </tr>
         <tr>
          <td> Past Conditional Form</td>
          <td>${Positive_Polite_Conditional_Form}</td>
          <td>${Negative_Polite_Conditional_Form}</td>
          <td>Used to politely describe various "if" meanings, past occurence, hypothesis etc.</td>
        </tr>
      </table>
     
 <br>
 <br>
    </div>
  </div> <!-- row -->

</div>


</body>
</html>
