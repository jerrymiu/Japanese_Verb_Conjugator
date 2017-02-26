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
    <a type="button" class="btn btn-lg btn-primary" href="https://github.com/jerrymiu/"><span class="glyphicon glyphicon-download"></span> Source on GitHub</a>
  </div>
</div>
<div class="container">
  
  <hr>
  <div class="row">
  
    <div class="col-md-12">
      <h3><span class="glyphicon glyphicon-link"></span> Conjugator</h3>
          <p>Expected input is of the basic dictionary form, e.g. 見る、考える、食べる、着る</p>
      <form action="/result" method="post">
        <input type="text" name="rawverb" id = "rawverb" placeholder = "Enter a verb" required="true">
      </form>
 <br>
 <br>
    </div>
  </div> <!-- row -->
  <p>${message}</p>
</div>


</body>
</html>
