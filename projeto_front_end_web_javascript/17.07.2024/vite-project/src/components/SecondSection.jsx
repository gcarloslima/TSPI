import BoxGrid from "./BoxGrid"
import PresentationSection from "./PresentationSection"

function SecondSection() {

    const infoBoxes = [
        { id: 0, nome: "Caixa de Destaque" },
        { id: 1, nome: "InfoBox Interativo" },
        { id: 2, nome: "Quadro de Dados" },
    ];

    return (
        <section>
            <PresentationSection title="Título 2" subtitle="Subtítulo 2" />
            <BoxGrid infoBoxes={infoBoxes} />
        </section>
    )
}

export default SecondSection
