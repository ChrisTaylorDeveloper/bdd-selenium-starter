from flask import Flask

app = Flask(__name__)


@app.route("/")
def hello():
    return """<!doctype html>
<html lang="en-us">   
  <head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
      $("#hide").click(function(){
        $("p").hide();
      });
      $("#show").click(function(){
        $("p").show();
      });
    });
    </script>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>bdd Selenium Start</title>
  </head>
  <body>
    <h1>bdd Selenium Start home page</h1>
    <p>This is the home page of our application.</p>
    <p>If you click the "Show" button, I will list some colours.</p>
    <button id="show">Show</button>
    <p id="colours-list" style="display:none">Red, Blue, Yellow, White.</p>
  </body> 
</html>"""
if __name__ == "__main__":
    # Only for debugging while developing
    app.run(host="0.0.0.0", debug=True, port=80)
