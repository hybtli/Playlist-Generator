import java.io.*;

public class FileIO {

    public static void readFile(IBag<Acoustic> acoustic,IBag<Instrumental> instrumental,IBag<Rock> rock,
                                IBag<Rap> rap,IBag<Jazz> jazz,IBag<Pop> pop,IBag<Music> music) throws IOException{

        String file = "src\\tracks.txt";
        String line;

        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null){

            String[] splitLine = line.split(",");
            music.add(new Music(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                    Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));

            switch (splitLine[0]) {
                case "1" -> acoustic.add(new Acoustic(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
                case "2" -> instrumental.add(new Instrumental(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
                case "3" -> rock.add(new Rock(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
                case "4" -> rap.add(new Rap(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
                case "5" -> jazz.add(new Jazz(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
                case "6" -> pop.add(new Pop(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                        Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3])));
            }

        }
        br.close();


    }

}
