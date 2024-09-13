import React from 'react';
import TitleBox from './components/TitleBox';
import ContentGrid from './components/ContentGrid';

function App() {

  const items = [
    { title: 'Plano de Desenvolvimento Institucional' },
    { title: 'Pesquisa Pública Processos IFTM' },
    { title: 'Licitações e Contratos' },
    { title: 'Receitas e Despesas' },
    { title: 'Dados Abertos' },
    { title: 'Transparência e Prestação de Contas' },
    { title: 'Servidores' },
    { title: 'Perguntas Frequentes' },
  ]

  return (
    <div className='bodyContent'>
      <section>
        <div className='sectionBox'>
          <TitleBox title="Acesso à informação" description="Veja dados de transparência e governança" />
          <ContentGrid items={items} />
        </div>
      </section>
      {/* <section>
        <TitleBox title="Acesso à informação 2" description="Veja dados de transparência e governança 2"/>
        <ContentBox title="BIBLIOTECA" src="biblioteca.png"/>
      </section>
      <section>
        <TitleBox title="Acesso à informação 3" description="Veja dados de transparência e governança 3"/>
        <ContentBox title="BIBLIOTECA" src="biblioteca.png"/>
      </section> */}
    </div>
  );
}

export default App;