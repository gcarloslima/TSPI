import React from 'react'
import { FloatingWhatsApp } from 'react-floating-whatsapp'

export default function Whatsapp() {
    return (
        <FloatingWhatsApp phoneNumber={import.meta.env.VITE_PROJECT_PHONE_NUMBER} accountName='Impusione a sua carreira profissional' chatMessage='Seja bem-vindo a nossa equipe de suporte. Informe a sua mensagem abaixo:' statusMessage='' placeholder='Digite a sua mensagem' allowClickAway={true} allowEsc={true} />
    )
}