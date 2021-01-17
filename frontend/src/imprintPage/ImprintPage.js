import React from 'react';
import { useHistory } from 'react-router-dom';
import styled from 'styled-components/macro';
import Header from '../component/Header';
import ActionButton from "../buttons/ActionButton";

export default function Imprint() {
  const history = useHistory();

  return (
    <>
      <Header title="Impressum" />
      <Content>
        <p>
          Sven Reymann
          <br />
          Kurdamm 4b
          <br />
          21107 Hamburg
        </p>
        <p>
          Telefon: +49 171 3134552
          <br />
          <a href="mailto:reymann78@freenet.de">reymann78@freenet.de</a>
        </p>

        <meta
          name="generator"
          content="Impressum-Generator der Kanzlei Hensche Rechtsanwälte"
        />
        <h1>Disclaimer - rechtliche Hinweise</h1>
        <p>
          <strong>Auskunfts- und Widerrufsrecht</strong>
        </p>
        <p>
          Sie haben jederzeit das Recht, sich unentgeltlich und unverzüglich
          über die zu Ihrer Person erhobenen Daten zu erkundigen. Ebenfalls
          können Sie Ihre Zustimmung zur Verwendung Ihrer angegebenen
          persönlichen Daten mit Wirkung für die Zukunft widerrufen. Hierfür
          wenden Sie sich bitte an den im Impressum angegebenen Diensteanbieter.
        </p>
        <p>
          <strong>Datenschutz (allgemein)</strong>
        </p>
        <p>
          Beim Zugriff auf unsere Webseite werden automatisch allgemeine
          Informationen (sog. Server-Logfiles) erfasst. Diese beinhalten u.a.
          den von Ihnen verwendeten Webbrowser sowie Ihr Betriebssystem und
          Ihren Internet Service Provider. Diese Daten lassen keinerlei
          Rückschlüsse auf Ihre Person zu und werden von uns statistisch
          ausgewertet, um unseren Internetauftritt technisch und inhaltlich zu
          verbessern. Das Erfassen dieser Informationen ist notwendig, um den
          Inhalt der Webseite korrekt ausliefern zu können.
        </p>
        <p>
          Die Nutzung der Webseite ist grundsätzlich ohne Angabe
          personenbezogener Daten möglich. Soweit personenbezogene Daten
          (beispielsweise Name, Anschrift oder E-Mail-Adressen) erhoben werden,
          erfolgt dies, soweit möglich, stets auf freiwilliger Basis. Diese
          Daten werden ohne Ihre ausdrückliche Zustimmung nicht an Dritte
          weitergegeben.
        </p>
        <p>
          Sofern ein Vertragsverhältnis begründet, inhaltlich ausgestaltet oder
          geändert werden soll oder Sie an uns eine Anfrage stellen, erheben und
          verwenden wir personenbezogene Daten von Ihnen, soweit dies zu diesem
          Zwecke erforderlich ist (Bestandsdaten). Wir erheben, verarbeiten und
          nutzen personenbezogene Daten soweit dies erforderlich ist, um Ihnen
          die Inanspruchnahme des Webangebots zu ermöglichen (Nutzungsdaten).
          Sämtliche personenbezogenen Daten werden nur solange gespeichert wie
          dies für den genannten Zweck (Bearbeitung Ihrer Anfrage oder
          Abwicklung eines Vertrags) erforderlich ist. Hierbei werden steuer-
          und handelsrechtliche Aufbewahrungsfristen von uns berücksichtigt. Auf
          Anordnung der zuständigen Stellen müssen wir im Einzelfall Auskunft
          über diese Daten (Bestandsdaten) erteilen, soweit dies für Zwecke der
          Strafverfolgung, zur Gefahrenabwehr, zur Erfüllung der gesetzlichen
          Aufgaben der Verfassungsschutzbehörden oder des Militärischen
          Abschirmdienstes oder zur Durchsetzung der Rechte am geistigen
          Eigentum erforderlich ist.
        </p>
        <p>
          Wir weisen ausdrücklich darauf hin, dass die Datenübertragung im
          Internet (z. B. bei der Kommunikation per E-Mail) Sicherheitslücken
          aufweisen kann. Vor dem Zugriff auf Daten kann nicht lückenlos
          geschützt werden.
        </p>
        <p>
          Die Nutzung von im Rahmen der Impressumspflicht veröffentlichten
          Kontaktdaten durch Dritte zur übersendung von nicht ausdrücklich
          angeforderter Werbung und Informationsmaterialien wird hiermit
          ausdrücklich untersagt. Ausgenommen hiervon sind bestehende
          Geschäftsbeziehungen bzw. es liegt Ihnen eine entsprechende
          Einwilligung von uns vor.
        </p>
        <p>
          Die Anbieter und alle auf dieser Website genannten Dritten behalten
          sich ausdrücklich rechtliche Schritte im Falle der unverlangten
          Zusendung von Werbeinformationen vor. Gleiches gilt für die
          kommerzielle Verwendung und Weitergabe der Daten.
        </p>
        <p>
          <strong>Disclaimer (Haftungsausschluss)</strong>
        </p>
        <p>
          <strong>1. Haftung für Inhalte</strong>
        </p>
        <p>
          Als Diensteanbieter sind wir gemäß § 7 Abs. 1 TMG für eigene Inhalte
          auf diesen Seiten nach den allgemeinen Gesetzen verantwortlich. Nach
          §§ 8 bis 10 TMG sind wir als Diensteanbieter jedoch nicht
          verpflichtet, übermittelte oder gespeicherte fremde Informationen zu
          überwachen oder nach Umständen zu forschen, die auf eine rechtswidrige
          Tätigkeit hinweisen. Verpflichtungen zur Entfernung oder Sperrung der
          Nutzung von Informationen nach den allgemeinen Gesetzen bleiben
          hiervon unberührt. Eine diesbezügliche Haftung ist jedoch erst ab dem
          Zeitpunkt der Kenntnis einer konkreten Rechtsverletzung möglich. Bei
          Bekanntwerden von entsprechenden Rechtsverletzungen werden wir diese
          Inhalte umgehend entfernen.
        </p>
        <p>
          <strong>2. Haftung für Links</strong>
        </p>
        <p>
          Diese Website enthält Links zu externen Webseiten Dritter, auf deren
          Inhalte kein Einfluss genommen werden kann. Deshalb kann für diese
          fremden Inhalte auch keine Gewähr übernommen werden. Für die Inhalte
          der verlinkten Seiten ist stets der jeweilige Anbieter oder Betreiber
          der Seiten verantwortlich. Die verlinkten Seiten wurden zum Zeitpunkt
          der Verlinkung auf mögliche Rechtsverstöße überprüft. Rechtswidrige
          Inhalte waren zum Zeitpunkt der Verlinkung nicht erkennbar. Eine
          permanente inhaltliche Kontrolle der verlinkten Seiten ist jedoch ohne
          konkrete Anhaltspunkte einer Rechtsverletzung nicht zumutbar. Bei
          Bekanntwerden von Rechtsverletzungen werden derartige Links umgehend
          von dieser Website auf die rechtsverletzende Site entfernen.
        </p>
        <p>
          <strong>3. Urheberrecht</strong>
        </p>
        <p>
          Die durch die Diensteanbieter, deren Mitarbeiter und beauftragte
          Dritte erstellten Inhalte und Werke auf diesen Seiten unterliegen dem
          deutschen Urheberrecht. Die Vervielfältigung, Bearbeitung, Verbreitung
          und jede Art der Verwertung außerhalb der Grenzen des Urheberrechtes
          bedürfen der vorherigen schriftlichen Zustimmung des jeweiligen Autors
          bzw. Erstellers. Downloads und Kopien dieser Seite sind nur für den
          privaten, nicht kommerziellen Gebrauch gestattet. Soweit die Inhalte
          auf dieser Seite nicht vom Betreiber erstellt wurden, werden die
          Urheberrechte Dritter beachtet. Insbesondere werden Inhalte Dritter
          als solche gekennzeichnet. Sollten Sie trotzdem auf eine
          Urheberrechtsverletzung aufmerksam werden, bitten wir um einen
          entsprechenden Hinweis. Bei Bekanntwerden von Rechtsverletzungen
          werden derartige Inhalte umgehend entfernen.
        </p>
        <p>
          Dieses Impressum wurde mit Hilfe des{' '}
          <a href="http://www.hensche.de/impressum-generator.html">
            Impressum-Generators
          </a>{' '}
          von{' '}
          <a href="http://www.hensche.de/Rechtsanwalt_Arbeitsrecht_Hamburg.html">
            HENSCHE Rechtsanw&auml;lte, Kanzlei f&uuml;r Arbeitsrecht
          </a>{' '}
          erstellt.
        </p>
      </Content>
      <ActionButton key="back" onClick={handleGoBack}>Zurück</ActionButton>
    </>
  );

  function handleGoBack() {
    history.goBack();
  }
}

const Content = styled.section`
  text-align: start;

  padding: var(--size-s);
  color: var(--blue-main);
  font-size: var(--size-s);
`;

