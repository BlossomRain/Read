from flask import Flask

app = Flask(__name__)


@app.route("/")
def hello() -> str:
    return "Hello world from Flask"


print(__name__)
app.run()
