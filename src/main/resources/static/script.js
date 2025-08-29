document.addEventListener('DOMContentLoaded', function() {
    const recipeForm = document.getElementById('recipe-form');

    recipeForm.addEventListener('submit', async function(e) {
        e.preventDefault();

        const recipeData = {
            title: document.getElementById('title').value,
            description: document.getElementById('description').value,
            ingredient: document.getElementById('ingredient').value,
            category: document.getElementById('category').value.toUpperCase()
        };

        try {
            const response = await fetch('http://localhost:8080/api/recipe/', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(recipeData)
            });

            if (response.ok) {
                const result = await response.json();
                console.log('Receita criada com sucesso:', result);
                alert('Receita criada com sucesso!');
                
                recipeForm.reset();
            } else {
                const error = await response.text();
                console.error('Erro ao criar receita:', error);
                alert('Erro ao criar receita: ' + error);
            }
        } catch (error) {
            console.error('Erro na requisição:', error);
            alert('Erro de conexão: ' + error.message);
        }
    });
});