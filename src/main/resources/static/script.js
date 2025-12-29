const form = document.getElementById("aprovadoForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  mensagem.innerHTML = "Enviando...";
  mensagem.className = "text-primary text-center";

  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const telefone = document.getElementById("telefone").value;
  const concursos = document.getElementById("concursos").value;
  const imagem = document.getElementById("imagem").files[0];

  try {
    // Upload da imagem
    const formData = new FormData();
    formData.append("file", imagem);

    const uploadResponse = await fetch(
      "http://localhost:8080/api/file/v1/uploadFile",
      {
        method: "POST",
        body: formData,
      }
    );

    const uploadData = await uploadResponse.json();

    // Cadastro do aprovado
    const aprovado = {
      nome,
      email,
      telefone,
      concursos,
      imagemPath: uploadData.fileName,
    };

    const response = await fetch("http://localhost:8080/api/v1/aprovado", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(aprovado),
    });

    if (!response.ok) {
      throw new Error("Erro ao cadastrar");
    }

    mensagem.className = "text-success text-center";
    mensagem.innerText = "Cadastro realizado com sucesso!";
    form.reset();
  } catch (error) {
    mensagem.className = "text-danger text-center";
    mensagem.innerText = "Erro ao cadastrar. Verifique os dados.";
    console.error(error);
  }
});
