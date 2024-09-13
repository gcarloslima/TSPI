import { useState } from 'react'
import Secao_Conversao from './components/Secao_Conversao/Secao_Conversao'
import Whatsapp from './components/Whatsapp/Whatsapp'
import Secao_FAQ from './components/Secao_FAQ/Secao_FAQ'

function App() {

  return (
    <>
      <main>
        <Whatsapp />
        <Secao_Conversao />
        <Secao_FAQ />
      </main>
    </>
  )
}

export default App
