import React from 'react';
import TitleBox from './components/TitleBox';
import ContentGrid from './components/ContentGrid';

function App() {

  const items = [
    { id: 1, title: 'Item 1', src: 'biblioteca.png' },
    { id: 2, title: 'Item 2', src: 'biblioteca.png' },
    { id: 3, title: 'Item 3', src: 'biblioteca.png' },
    { id: 4, title: 'Item 4', src: 'biblioteca.png' },
    { id: 5, title: 'Item 5' },
    { id: 6, src: 'biblioteca.png' },
    { id: 7, title: 'Item 7' },
    { id: 8, src: 'biblioteca.png' },
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