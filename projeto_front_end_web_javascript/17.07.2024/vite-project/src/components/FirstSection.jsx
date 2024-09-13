import BoxGrid from "./BoxGrid"
import PresentationSection from "./PresentationSection"

function FirstSection() {

    const infoBoxes = [
        { id: 0, nome: "Caixa de Destaque" },
        { id: 1, nome: "InfoBox Interativo" },
        { id: 2, nome: "Quadro de Dados" },
        { id: 3, nome: "Painel Informativo" },
        { id: 4, nome: "Caixa de Conhecimento" },
        { id: 5, nome: "Bloco de Insights" },
        { id: 6, nome: "Janela de Informações" }
    ];

    return (
        <section>
            <PresentationSection title="Título 1" subtitle="Subtítulo 1" />
            <BoxGrid infoBoxes={infoBoxes} />
        </section>
    )
}

export default FirstSection
