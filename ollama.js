const url = require('url');
const path = require('path');

// Importa el módulo de manera dinámica usando import()
import('node-llama-cpp').then(llamaCpp => {
    const { LlamaModel, LlamaContext, LlamaChatSession } = llamaCpp;

    const model = new LlamaModel({
        modelPath: path.join(__dirname, "models", "mini.gguf")
    });
    const context = new LlamaContext({ model });
    const session = new LlamaChatSession({ context });

    const q1 = "Hi there, how are you?";
    console.log("User: " + q1);

    session.prompt(q1).then(a1 => {
        console.log("AI: " + a1);

        const q2 = "Summerize what you said";
        console.log("User: " + q2);

        session.prompt(q2).then(a2 => {
            console.log("AI: " + a2);
        }).catch(error => console.error(error));
    }).catch(error => console.error(error));
}).catch(error => console.error(error));
