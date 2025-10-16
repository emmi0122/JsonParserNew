package se.berg.html;

public class CssRender {
    private String css;

    public CssRender(String css) {
        this.css = css;
    }

    public static String getCss() {
        return """
                    * {
                        margin: 0;
                        box-sizing: border-box;
                    }

                    body {
                        font-family: Arial, sans-serif;
                        margin: 2em 4em;
                        line-height: 1.5;
                    }

                    .header {
                        display: flex;
                        align-items: center;
                        justify-content: space-between;
                        margin-bottom: 2em;
                    }

                    .title {
                        text-align: right;
                    }

                    .title h2 {
                        margin: 0;
                    }

                    .header-table {
                        width: 100%;
                        border-collapse: collapse;
                        margin-bottom: 3em;
                        border: 2.5px solid #000;
                    }

                    .header-table td {
                        border: 2px solid #000;
                        padding: 0.6em;
                        vertical-align: top;
                    }

                    .header-table .empty-cell {
                        height: 2.5em;
                    }

                    .main-content h1 {
                        margin: 1.5em 0 0.5em 0;
                    }

                    .main-content h2 {
                        margin: 0 0 1.5em 0;
                    }

                    .project-info {
                        margin: 2em 0 3em 0;
                        line-height: 2;
                    }

                    .project-info p {
                        margin: 0.3em 0;
                    }

                    .toc {
                        margin: 3em 0;
                    }

                    .toc h3 {
                        margin-bottom: 1em;
                    }

                    .toc ol {
                        list-style: none;
                        counter-reset: section;
                        padding-left: 0;
                    }

                    .toc li {
                        counter-increment: section;
                        margin: 0.5em 0;
                    }

                    .toc li::before {
                        content: counter(section) " ";
                        display: inline-block;
                        width: 2em;
                        font-weight: normal;
                    }

                    .test-section {
                        margin: 3em 0;
                        page-break-inside: avoid;
                    }

                    .test-section h3 {
                        margin-bottom: 1em;
                    }

                    .test-table {
                        width: 100%;
                        border-collapse: collapse;
                        margin: 1em 0 2em 0;
                        border: 2.5px solid #000;
                    }

                    .test-table thead {
                        background-color: #f0f0f0;
                    }

                    .test-table th {
                        border: 2px solid #000;
                        padding: 0.6em;
                        text-align: left;
                    }

                    .test-table td {
                        border: 2px solid #000;
                        padding: 0.8em;
                        vertical-align: top;
                    }

                    .test-table .item-col {
                        width: 10%;
                        font-size: large;
                        font-weight: bold;
                    }

                    .test-table .description-col {
                        width: 70%;
                    }

                    .notes-section {
                        margin: 3em 0 3em 0;
                    }

                    .notes-section h3 {
                        margin-bottom: 1em;
                    }

                    .notes-table {
                        width: 100%;
                        border-collapse: collapse;
                        border: 2.5px solid #000;
                    }

                    .notes-table td {
                        border: 2px solid #000;
                        padding-top: 40em;
                    }
                """;
    }

    @Override
    public String toString() {
        return css;
    }
}