package com.br.webhook.shareds;

public interface Phases {

    String NEW_USER = "Olá! 👋🏽😃 Prazer em conhecê-lo! Eu sou o @viniBot, seu assistente especializado em downloads de vídeos " +
            "para MP3. Estou aqui para tornar o processo de obter suas músicas favoritas em MP3 o mais simples e rápido " +
            "possível. Como posso ajudar você hoje? 🎵";

    String MESSAGE_MENU = "Escolha uma das opções abaixo para começar:\n" +
            "\n" +
            "1️⃣ Download de música: Envie o link do vídeo para que eu possa converter e baixar a música em MP3 para você.\n" +
            "\n" +
            "~2️⃣ Alterar tom da música: Em desenvolvimento — Em breve, você poderá alterar o tom da música para ajustar à sua preferência.~\n" +
            "\n" +
            "~3️⃣ Alterar BPM da música: Em desenvolvimento — Em breve, você terá a opção de ajustar o ritmo da música conforme desejado.~\n" +
            "\n" +
            "~4️⃣ Separar faixas da música: Em desenvolvimento — Em breve, você poderá dividir a música em diferentes faixas para facilitar o uso.~\n" +
            "\n" +
            "Para começar, escolha a opção 1️⃣ e envie o link do vídeo que deseja. Estou aqui para ajudar! 🎵";

    String TRY_AGAIN = "Parece que não entendi a sua resposta. 😕 Não se preocupe, vamos voltar ao menu principal.";

    String DOWNLOAD_MUSIC = "1️⃣ Ótimo! Para baixar a música, por favor, envie o link do vídeo que você deseja converter para MP3.\n" +
            "\n" +
            "Aqui está um exemplo de como deve ser o link:\n" +
            "\n" +
            "Exemplo de link: https://www.youtube.com/watch?v=abcdefghijk\n" +
            "\n" +
            "Basta copiar e colar o link do vídeo no qual está a música que você quer baixar. Assim que eu receber o link, " +
            "começarei a conversão e o download para você! 🎵\n" +
            "\n" +
            "Se quiser voltar ao menu principal, digite menu a qualquer momento.";

    String PITCH_CHANGER = "Alterar tom";

    String BPM_MUSIC = "deescubra o bpm da musica";

    String WAIT_PROCESS = "Obrigado por enviar o link! 🎶\n" +
            "\n" +
            "Aguarde um momento enquanto eu estou processando sua solicitação. Isso pode levar alguns minutos. ⏳\n" +
            "\n" +
            "Fique tranquilo, e eu te informarei assim que a conversão estiver concluída.";

    String MESSAGE_FINISH = "Estamos quase lá! 🎉\n" +
            "\n" +
            "Para ajudar a manter e continuar desenvolvendo este projeto, pedimos um valor simbólico. " +
            "Sua contribuição é muito importante para que possamos oferecer um serviço cada vez melhor. \n" +
            "\n" +
            "Link para doação: Doe aqui\n" +
            "\n" +
            "Se tiver alguma dúvida ou quiser entrar em contato, aqui estão nossos canais:\n" +
            "\n" +
            "📧 Email: contato@example.com\n" +
            "🌐 Nosso site: www.example.com\n" +
            "\n" +
            "Agradecemos muito pelo seu apoio!😊";

    String SERVICE_ERROR = "Olá! 😕 Parece que houve um problema. Estamos trabalhando para resolver isso. Por favor, " +
            "tente novamente mais tarde. Obrigado pela compreensão!";

    String OPTION_NOT_AVAILABLE = "Olá! 👋 A opção que você tentou acessar não está disponível no momento. Para desbloquear " +
            "outras opções e ajudar na manutenção dos nossos servidores, você pode realizar uma doação simbólica. " +
            "Lembrando que nosso projeto é sem fins lucrativos, e todas as doações são integralmente usadas para o " +
            "desenvolvimento e manutenção dos sistemas. Agradecemos muito pelo seu apoio e compreensão! 🙏💖";

}