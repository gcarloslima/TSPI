import BoxGrid from "./BoxGrid"
import PresentationSection from "./PresentationSection"

function ThirdSection() {

    const infoBoxes = [
        { id: 0, nome: "Caixa de Destaque" }
    ];

    return (
        <section>
            <PresentationSection title="Título 3" subtitle="Subtítulo 3" />
            <BoxGrid infoBoxes={infoBoxes} />
        </section>
    )
}

export default ThirdSection
