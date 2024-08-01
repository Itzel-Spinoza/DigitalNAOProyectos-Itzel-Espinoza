from flask import Flask, render_template, request
import inflect

app = Flask(__name__)
p = inflect.engine()

@app.route('/', methods=['GET', 'POST'])
def index():
    words = ""
    if request.method == 'POST':
        number = request.form.get('number')
        if number.isdigit():
            words = p.number_to_words(number)
        else:
            words = "Please enter a valid number."
    return render_template('index.html', words=words)

if __name__ == '__main__':
    app.run(debug=True)
