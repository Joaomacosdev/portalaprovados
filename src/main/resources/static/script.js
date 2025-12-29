const form = document.getElementById("aprovadoForm");
const mensagem = document.getElementById("mensagem");

form.addEventListener("submit", async (e) => {
  e.preventDefault();

  mensagem.innerText = "Enviando...";
  mensagem.className = "text-primary text-center";

  const nome = document.getElementById("nome").value;
  const email = document.getElementById("email").value;
  const telefone = document.getElementById("telefone").value;
  const concursos = document.getElementById("concursos").value;
  const imagem = document.getElementById("imagem").files[0];

  if (!imagem) {
    mensagem.innerText = "Selecione uma imagem.";
    mensagem.className = "text-danger text-center";
    return;
  }

  try {
    // 1️⃣ Upload da imagem
    const formData = new FormData();
    formData.append("file", imagem);

    const uploadResponse = await fetch("/api/file/v1/uploadFile", {
      method: "POST",
      body: formData
    });

    if (!uploadResponse.ok) {
      throw new Error("Erro no upload da imagem");
    }

    const uploadData = await uploadResponse.json();

    // 2️⃣ Cadastro do aprovado
    const aprovado = {
      nome,
      email,
      telefone,
      concursos,
      imagemPath: uploadData.fileName,
    };

    const response = await fetch("/api/v1/aprovado", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(aprovado),
    });

    if (!response.ok) {
      throw new Error("Erro ao cadastrar aprovado");
    }

    mensagem.className = "text-success text-center";
    mensagem.innerText = "Cadastro realizado com sucesso!";
    form.reset();

  } catch (error) {
    console.error(error);
    mensagem.className = "text-danger text-center";
    mensagem.innerText = "Erro ao cadastrar. Verifique os dados.";
  }
});
