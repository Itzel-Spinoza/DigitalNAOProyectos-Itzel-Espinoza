const startBtn = document.getElementById('start-btn');
const transcriptP = document.getElementById('transcript');

window.SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;

if (window.SpeechRecognition) {
    const recognition = new SpeechRecognition();
    recognition.lang = 'es-ES'; // Cambia a 'en-US' si prefieres el inglés
    recognition.interimResults = false;
    recognition.maxAlternatives = 1;

    recognition.onstart = () => {
        startBtn.textContent = 'Listening...';
    };

    recognition.onend = () => {
        startBtn.textContent = 'Start Recording';
    };

    recognition.onresult = (event) => {
        const transcript = event.results[0][0].transcript;
        transcriptP.textContent = `You said: ${transcript}`;
    };

    recognition.onerror = (event) => {
        transcriptP.textContent = `Error occurred in recognition: ${event.error}`;
    };

    startBtn.addEventListener('click', () => {
        recognition.start();
    });
} else {
    transcriptP.textContent = 'Sorry, your browser does not support Speech Recognition.';
}
