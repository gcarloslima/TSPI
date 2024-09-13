import { useEffect, useState } from 'react';
import './Secao_Conversao.module.css';
import emailjs from '@emailjs/browser';

function Secao_Conversao() {

	const [form, setForm] = useState({
		nome: "",
		email: ""
	})

	const getData = e => {
		setForm({ ...form, [e.target.name]: e.target.value })
		console.log(JSON.stringify(form, null, 2))
	}

	const validar = () => {
		if (form.nome === "" || form.email === "") {
			alert('Todos campos precisam ser preenchidos!')
		}
		else {
			var templateParams = {
				from_name: form.nome,
				from_email: form.email
			}

			emailjs.send(
				import.meta.env.VITE_PROJECT_SERVICE_ID,
				import.meta.env.VITE_PROJECT_TEMPLATE_ID,
				templateParams,
				import.meta.env.VITE_PROJECT_PUBLIC_KEY
			).then(
				(response) => {
					console.log('SUCCESS!', response.status, response.text);
				},
				(error) => {
					console.log('FAILED...', error);
				},
			);
		}
	}

	return (
		<section>
			<div className='container'>
				<h2>Quero participar do treinamento</h2>
				<p>Vagas limitadas. Clique no botão abaixo e inicie essa jornada conosco</p>
				<form action="">
					<div>
						<label htmlFor="nome">Nome: </label>
						<input type="text" name="nome" onChange={getData} />
					</div>
					<div>
						<label htmlFor="email">Email: </label>
						<input type="email" name="email" onChange={getData} />
					</div>
					<input type="button" value="Enviar" onClick={validar} />
				</form>
			</div>
		</section>
	)
}

export default Secao_Conversao;