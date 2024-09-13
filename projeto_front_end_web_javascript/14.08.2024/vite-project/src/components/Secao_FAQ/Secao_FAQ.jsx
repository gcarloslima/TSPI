import { useEffect, useState } from 'react'
import css from './Secao_FAQ.module.css'

export default function Secao_FAQ() {

	const [faqs, setFaqs] = useState([]);

	useEffect(() => {
		fetch('https://wilton-filho.github.io/PFJS-GitHub/React/projeto/json/faq.json')
			.then(file => file.json())
			.then(info => setFaqs(info.faqs))
	}, [])

	function getPerguntas() {
		if (faqs.length > 0) {
			return faqs.map((faq, index) => {
				return (
					<details key={index}>
						<summary>{faq.pergunta}</summary>
						<p>{faq.resposta}</p>
					</details>
				)
			})
		}
		
	}

	return (

		<section>
			<div className='container'>
				<h2>FAQ</h2>
				<span>{getPerguntas()}</span>
			</div>
		</section>

	)

}
