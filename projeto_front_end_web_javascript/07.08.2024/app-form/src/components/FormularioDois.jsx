import React, { useState } from 'react';

function FormularioDois() {
    const [form, setForm] = useState({
        nome: "",
        email: ""
    });

    const handleChange = ({ target: { value: valor, name }}) => {
        switch (name) {
            case 'nome':
                setForm({
                    nome: valor,
                    email: form.email
                })
                break;
            case 'email':
                setForm({
                    nome: form.nome,
                    email: valor
                })
                break;
        }
        
        setForm({
            nome: texto,
            email: texto
        })    
    }
    
    return (
        <form>
            <div>
                <label htmlFor="">Nome: </label>
                <input type="text" name="nome" onChange={handleChange} />
            </div>
            <div>
                <label htmlFor="">E-mail: </label>
                <input type="email" name="email" onChange={handleChange} />
            </div>
            <p>{JSON.stringify(form, null, 2)}</p>
        </form>
    );
}

export default FormularioDois;