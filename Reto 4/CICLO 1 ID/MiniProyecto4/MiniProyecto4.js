const fecha_limite = new Date('01/01/2025 0:00 AM');

const span_dias = document.querySelector('span#dias');
const span_horas = document.querySelector('span#horas');
const span_minutos = document.querySelector('span#minutos');
const span_segundos = document.querySelector('span#segundos');

const milisegundos_de_un_segundo = 1000;
const milisegundos_de_un_minuto = milisegundos_de_un_segundo * 60;
const milisegundos_de_una_hora = milisegundos_de_un_minuto * 60;
const milisegundos_de_un_dia = milisegundos_de_una_hora * 24;

function actualizarContador() {
    const ahora = new Date();
    const duracion = fecha_limite - ahora;

    const dias_faltantes = Math.floor(duracion / milisegundos_de_un_dia);
    const horas_faltantes = Math.floor((duracion % milisegundos_de_un_dia) / milisegundos_de_una_hora);
    const minutos_faltantes = Math.floor((duracion % milisegundos_de_una_hora) / milisegundos_de_un_minuto);
    const segundos_faltantes = Math.floor((duracion % milisegundos_de_un_minuto) / milisegundos_de_un_segundo);

    span_dias.textContent = dias_faltantes;
    span_horas.textContent = horas_faltantes;
    span_minutos.textContent = minutos_faltantes;
    span_segundos.textContent = segundos_faltantes;
}

actualizarContador();
setInterval(actualizarContador, milisegundos_de_un_segundo);
