package anadiapp.ui;

import anadiapp.model.Result;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by skimi on 25/04/2017.
 */
public class SendToTxt {
    // ATENCAO!! Nao user tempos no filename!! Converter para string primeiro
    private static final String FILENAME = "test_";
    private static final String EXTENSION = ".csv";
    private static final String HEADER = "Data_Hora_Inicio;IntervaloAmostragem(seg);Node;Porto;Timeout(seg);DuracaoTeste(min);Data_Hora_Fim;"
            + "TotalAmostragens;Sucessos;Dispon;MTBF(hor)"+"\n";

    private File file = null;
    private FileWriter fileWriter = null;
    private Result result = null;

    public SendToTxt(Result result) throws IOException
    {
        this.result = result;
        this.fileWriter = generateWriter();
    }

    private FileWriter generateWriter() throws IOException
    {
        String node = this.result.getConfig().getNode();
        String name = String.format("%s_%s%s", FILENAME, node, EXTENSION);
        this.file = new File(name);
        return new FileWriter(this.file, true);
    }

    public void export() throws IOException
    {
        int numLines = countLines();
        if (numLines == 0) {
            this.fileWriter.write(HEADER);
        }
        this.fileWriter.write(String.format("%d", this.result.getTestInit().getTimeInMillis() / 1000));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getConfig().getTimeInterval()));
        this.fileWriter.write(";");
        this.fileWriter.write(this.result.getConfig().getNode());
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getConfig().getPort()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getConfig().getTimeout()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%.2f", this.result.getConfig().getDuration()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getTestEnd().getTimeInMillis() / 1000));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getTotalSampling()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%d", this.result.getSucess()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%.2f", this.result.getAvailability()));
        this.fileWriter.write(";");
        this.fileWriter.write(String.format("%.2f", this.result.getMtbf()));
        this.fileWriter.write("\n");

        this.fileWriter.close();
    }

    private int countLines() throws IOException
    {
        int n = 0;
        Scanner s = new Scanner(this.file);
        while (s.hasNextLine()) {
            n++;
            s.nextLine();
        }
        return n;
    }
}
