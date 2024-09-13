import React, { useState } from 'react';

function Formulario() {
    const [nome, setNome] = useState('');
    const [email, setEmail] = useState('');

    const handleChange = ({ target: { value: texto }}) => {
        
    }

    return (
        <form>
            <div>
                <label htmlFor="">Nome: </label>
                <input type="text" onChange={({ target: { value: texto } }) => setNome(texto)} />
                <p>{nome}</p>
            </div>
            <div>
                <label htmlFor="">E-mail: </label>
                <input type="email" onChange={({ target: { value: texto } }) => setEmail(texto)} />
                <p>{email}</p>
            </div>
        </form>
    );
}

export default Formulario;