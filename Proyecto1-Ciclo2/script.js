function scrollToForm() {
    document.getElementById('formulario').scrollIntoView({ behavior: 'smooth' });
  }

  function validarFormulario() {
    var email = document.getElementById("email").value;
    var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regex.test(email)) {
      alert("Por favor, introduce una dirección de correo electrónico válida.");
      return false;
    }
    return true;
  }