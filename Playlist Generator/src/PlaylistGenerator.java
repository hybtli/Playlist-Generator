import java.io.IOException;
import java.util.Scanner;

public class PlaylistGenerator {

    public void generator() throws IOException {

        IBag<Acoustic> acoustic = new ArrayBag<>();
        IBag<Instrumental> instrumental = new ArrayBag<>();
        IBag<Rock> rock = new ArrayBag<>();
        IBag<Rap> rap = new ArrayBag<>();
        IBag<Jazz> jazz = new ArrayBag<>();
        IBag<Pop> pop = new ArrayBag<>();
        IBag<Music> music = new ArrayBag<>();

        IBag<Music> sleeping = new Sleeping<>();
        IBag<Music> workout = new Workout<>();
        IBag<Music> dining = new Dining<>();
        IBag<Music> meditation = new Meditation<>();
        IBag<Music> roadTrip = new RoadTrip<>();


        FileIO.readFile(acoustic,instrumental,rock,rap,jazz,pop,music);

        System.out.println("Number of tracks in the acoustic genre: " + acoustic.getCurrentSize());
        int totalAcoustic = 0;
        for (int index = 0; index < acoustic.getCurrentSize(); index++) {
            totalAcoustic += acoustic.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the acoustic genre: " + totalAcoustic/60 + " min " + totalAcoustic%60 + " sec");
        System.out.println();

        System.out.println("Number of tracks in the instrumental genre: " + instrumental.getCurrentSize());
        int totalInstrumental = 0;
        for (int index = 0; index < instrumental.getCurrentSize(); index++) {
            totalInstrumental += instrumental.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the instrumental genre: " + totalInstrumental/60 + " min " + totalInstrumental%60 + " sec");
        System.out.println();

        System.out.println("Number of tracks in the rock genre: " + rock.getCurrentSize());
        int totalRock = 0;
        for (int index = 0; index < rock.getCurrentSize(); index++) {
            totalRock += rock.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the rock genre: " + totalRock/60 + " min " + totalRock%60 + " sec");
        System.out.println();

        System.out.println("Number of tracks in the rap genre: " + rap.getCurrentSize());
        int totalRap = 0;
        for (int index = 0; index < rap.getCurrentSize(); index++) {
            totalRap += rap.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the rap genre: " + totalRap/60 + " min " + totalRap%60 + " sec");
        System.out.println();

        System.out.println("Number of tracks in the jazz genre: " + jazz.getCurrentSize());
        int totalJazz = 0;
        for (int index = 0; index < jazz.getCurrentSize(); index++) {
            totalJazz += jazz.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the jazz genre: " + totalJazz/60 + " min " + totalJazz%60 + " sec");
        System.out.println();

        System.out.println("Number of tracks in the pop genre: " + pop.getCurrentSize());
        int totalPop = 0;
        for (int index = 0; index < pop.getCurrentSize(); index++) {
            totalPop += pop.getItemByIndex(index).getTrack_duration();
        }
        System.out.println("Total duration of the pop genre: " + totalPop/60 + " min " + totalPop%60 + " sec");
        System.out.println();

        Menu menu = new Menu();
        menu.mainMenu();


        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your option: ");
            int userInput = scanner.nextInt();

            if (userInput == 0){
                System.out.println("Exited!");
                break;
            }

            else if (userInput == 1) {
                while (!sleeping.isArrayFull()) {
                    if (!instrumental.isEmpty()) {

                        int maxInstrumental = instrumental.getItemByIndex(0).getTrack_popularity();
                        int indexInstrumental = 0;

                        for (int i = 0; i < instrumental.getCurrentSize(); i++) {
                            if (instrumental.getItemByIndex(i).getTrack_popularity() > maxInstrumental) {
                                maxInstrumental = instrumental.getItemByIndex(i).getTrack_popularity();
                                indexInstrumental = i;
                            }
                        }

                        sleeping.add(instrumental.getItemByIndex(indexInstrumental));
                        instrumental.remove(instrumental.getItemByIndex(indexInstrumental));
                    } else if (!acoustic.isEmpty()) {
                        int maxAcoustic = acoustic.getItemByIndex(0).getTrack_popularity();
                        int indexAcoustic = 0;

                        for (int i = 0; i < acoustic.getCurrentSize(); i++) {
                            if (acoustic.getItemByIndex(i).getTrack_popularity() > maxAcoustic) {
                                maxAcoustic = acoustic.getItemByIndex(i).getTrack_popularity();
                                indexAcoustic = i;
                            }
                        }

                        sleeping.add(acoustic.getItemByIndex(indexAcoustic));
                        acoustic.remove(acoustic.getItemByIndex(indexAcoustic));
                    } else if (!jazz.isEmpty()) {
                        int maxJazz = jazz.getItemByIndex(0).getTrack_popularity();
                        int indexJazz = 0;

                        for (int i = 0; i < jazz.getCurrentSize(); i++) {
                            if (jazz.getItemByIndex(i).getTrack_popularity() > maxJazz) {
                                maxJazz = jazz.getItemByIndex(i).getTrack_popularity();
                                indexJazz = i;
                            }
                        }

                        sleeping.add(jazz.getItemByIndex(indexJazz));
                        jazz.remove(jazz.getItemByIndex(indexJazz));
                    }

                }
                System.out.println("Number of tracks in the playlist: " + sleeping.getCurrentSize());

                int totalDuration = 0;
                for (int index = 0; index < sleeping.getCurrentSize(); index++) {
                    totalDuration += sleeping.getItemByIndex(index).getTrack_duration();
                }
                System.out.println("Total duration of the playlist: " + totalDuration / 60 + " min " + totalDuration % 60 + " sec");

                int totalPopularity = 0;
                for (int index = 0; index < sleeping.getCurrentSize(); index++) {
                    totalPopularity += sleeping.getItemByIndex(index).getTrack_popularity();
                }
                System.out.println("Average popularity of the playlist: " + (totalPopularity / sleeping.getCurrentSize()));
                sleeping.displayItems();
            } else if (userInput == 2) {
                while (!workout.isArrayFull()) {
                    if (!rap.isEmpty()) {
                        int maxRap = rap.getItemByIndex(0).getTrack_popularity();
                        int indexRap = 0;

                        for (int i = 0; i < rap.getCurrentSize(); i++) {
                            if (rap.getItemByIndex(i).getTrack_popularity() > maxRap) {
                                maxRap = rap.getItemByIndex(i).getTrack_popularity();
                                indexRap = i;
                            }
                        }

                        workout.add(rap.getItemByIndex(indexRap));
                        rap.remove(rap.getItemByIndex(indexRap));
                    } else if (!rock.isEmpty()) {
                        int maxRock = rock.getItemByIndex(0).getTrack_popularity();
                        int indexRock = 0;

                        for (int i = 0; i < rock.getCurrentSize(); i++) {
                            if (rock.getItemByIndex(i).getTrack_popularity() > maxRock) {
                                maxRock = rock.getItemByIndex(i).getTrack_popularity();
                                indexRock = i;
                            }
                        }

                        workout.add(rock.getItemByIndex(indexRock));
                        rock.remove(rock.getItemByIndex(indexRock));
                    } else if (!pop.isEmpty()) {
                        int maxPop = pop.getItemByIndex(0).getTrack_popularity();
                        int indexPop = 0;

                        for (int i = 0; i < pop.getCurrentSize(); i++) {
                            if (pop.getItemByIndex(i).getTrack_popularity() > maxPop) {
                                maxPop = pop.getItemByIndex(i).getTrack_popularity();
                                indexPop = i;
                            }
                        }

                        workout.add(pop.getItemByIndex(indexPop));
                        pop.remove(pop.getItemByIndex(indexPop));
                    }
                }
                System.out.println("Number of tracks in the playlist: " + workout.getCurrentSize());

                int totalDuration = 0;
                for (int index = 0; index < workout.getCurrentSize(); index++) {
                    totalDuration += workout.getItemByIndex(index).getTrack_duration();
                }
                System.out.println("Total duration of the playlist: " + totalDuration / 60 + " min " + totalDuration % 60 + " sec");

                int totalPopularity = 0;
                for (int index = 0; index < workout.getCurrentSize(); index++) {
                    totalPopularity += workout.getItemByIndex(index).getTrack_popularity();
                }
                System.out.println("Average popularity of the playlist: " + (totalPopularity / workout.getCurrentSize()));
                workout.displayItems();

            } else if (userInput == 3) {
                while (!dining.isArrayFull()) {
                    if (!jazz.isEmpty()) {
                        int maxJazz = jazz.getItemByIndex(0).getTrack_popularity();
                        int indexJazz = 0;

                        for (int i = 0; i < jazz.getCurrentSize(); i++) {
                            if (jazz.getItemByIndex(i).getTrack_popularity() > maxJazz) {
                                maxJazz = jazz.getItemByIndex(i).getTrack_popularity();
                                indexJazz = i;
                            }
                        }

                        dining.add(jazz.getItemByIndex(indexJazz));
                        jazz.remove(jazz.getItemByIndex(indexJazz));
                    } else if (!acoustic.isEmpty()) {
                        int maxAcoustic = acoustic.getItemByIndex(0).getTrack_popularity();
                        int indexAcoustic = 0;

                        for (int i = 0; i < acoustic.getCurrentSize(); i++) {
                            if (acoustic.getItemByIndex(i).getTrack_popularity() > maxAcoustic) {
                                maxAcoustic = acoustic.getItemByIndex(i).getTrack_popularity();
                                indexAcoustic = i;
                            }
                        }

                        dining.add(acoustic.getItemByIndex(indexAcoustic));
                        acoustic.remove(acoustic.getItemByIndex(indexAcoustic));
                    } else if (!instrumental.isEmpty()) {

                        int maxInstrumental = instrumental.getItemByIndex(0).getTrack_popularity();
                        int indexInstrumental = 0;

                        for (int i = 0; i < instrumental.getCurrentSize(); i++) {
                            if (instrumental.getItemByIndex(i).getTrack_popularity() > maxInstrumental) {
                                maxInstrumental = instrumental.getItemByIndex(i).getTrack_popularity();
                                indexInstrumental = i;
                            }
                        }

                        dining.add(instrumental.getItemByIndex(indexInstrumental));
                        instrumental.remove(instrumental.getItemByIndex(indexInstrumental));
                    }
                }
                System.out.println("Number of tracks in the playlist: " + workout.getCurrentSize());

                int totalDuration = 0;
                for (int index = 0; index < dining.getCurrentSize(); index++) {
                    totalDuration += dining.getItemByIndex(index).getTrack_duration();
                }
                System.out.println("Total duration of the playlist: " + totalDuration / 60 + " min " + totalDuration % 60 + " sec");

                int totalPopularity = 0;
                for (int index = 0; index < dining.getCurrentSize(); index++) {
                    totalPopularity += dining.getItemByIndex(index).getTrack_popularity();
                }
                System.out.println("Average popularity of the playlist: " + (totalPopularity / dining.getCurrentSize()));
                dining.displayItems();
            } else if (userInput == 4) {
                while (!meditation.isArrayFull()) {
                    if (!instrumental.isEmpty()) {

                        int maxInstrumental = instrumental.getItemByIndex(0).getTrack_popularity();
                        int indexInstrumental = 0;

                        for (int i = 0; i < instrumental.getCurrentSize(); i++) {
                            if (instrumental.getItemByIndex(i).getTrack_popularity() > maxInstrumental) {
                                maxInstrumental = instrumental.getItemByIndex(i).getTrack_popularity();
                                indexInstrumental = i;
                            }
                        }

                        meditation.add(instrumental.getItemByIndex(indexInstrumental));
                        instrumental.remove(instrumental.getItemByIndex(indexInstrumental));
                    } else if (!acoustic.isEmpty()) {
                        int maxAcoustic = acoustic.getItemByIndex(0).getTrack_popularity();
                        int indexAcoustic = 0;

                        for (int i = 0; i < acoustic.getCurrentSize(); i++) {
                            if (acoustic.getItemByIndex(i).getTrack_popularity() > maxAcoustic) {
                                maxAcoustic = acoustic.getItemByIndex(i).getTrack_popularity();
                                indexAcoustic = i;
                            }
                        }

                        meditation.add(acoustic.getItemByIndex(indexAcoustic));
                        acoustic.remove(acoustic.getItemByIndex(indexAcoustic));
                    } else if (!jazz.isEmpty()) {
                        int maxJazz = jazz.getItemByIndex(0).getTrack_popularity();
                        int indexJazz = 0;

                        for (int i = 0; i < jazz.getCurrentSize(); i++) {
                            if (jazz.getItemByIndex(i).getTrack_popularity() > maxJazz) {
                                maxJazz = jazz.getItemByIndex(i).getTrack_popularity();
                                indexJazz = i;
                            }
                        }

                        meditation.add(jazz.getItemByIndex(indexJazz));
                        jazz.remove(jazz.getItemByIndex(indexJazz));
                    }

                }
                System.out.println("Number of tracks in the playlist: " + meditation.getCurrentSize());

                int totalDuration = 0;
                for (int index = 0; index < meditation.getCurrentSize(); index++) {
                    totalDuration += meditation.getItemByIndex(index).getTrack_duration();
                }
                System.out.println("Total duration of the playlist: " + totalDuration / 60 + " min " + totalDuration % 60 + " sec");

                int totalPopularity = 0;
                for (int index = 0; index < meditation.getCurrentSize(); index++) {
                    totalPopularity += meditation.getItemByIndex(index).getTrack_popularity();
                }
                System.out.println("Average popularity of the playlist: " + (totalPopularity / meditation.getCurrentSize()));
                meditation.displayItems();
            } else if (userInput == 5) {
                while (!roadTrip.isArrayFull()) {
                    if (!rock.isEmpty()) {
                        int maxRock = rock.getItemByIndex(0).getTrack_popularity();
                        int indexRock = 0;

                        for (int i = 0; i < rock.getCurrentSize(); i++) {
                            if (rock.getItemByIndex(i).getTrack_popularity() > maxRock) {
                                maxRock = rock.getItemByIndex(i).getTrack_popularity();
                                indexRock = i;
                            }
                        }

                        roadTrip.add(rock.getItemByIndex(indexRock));
                        rock.remove(rock.getItemByIndex(indexRock));
                    } else if (!pop.isEmpty()) {
                        int maxPop = pop.getItemByIndex(0).getTrack_popularity();
                        int indexPop = 0;

                        for (int i = 0; i < pop.getCurrentSize(); i++) {
                            if (pop.getItemByIndex(i).getTrack_popularity() > maxPop) {
                                maxPop = pop.getItemByIndex(i).getTrack_popularity();
                                indexPop = i;
                            }
                        }

                        roadTrip.add(pop.getItemByIndex(indexPop));
                        pop.remove(pop.getItemByIndex(indexPop));
                    } else if (!acoustic.isEmpty()) {
                        int maxAcoustic = acoustic.getItemByIndex(0).getTrack_popularity();
                        int indexAcoustic = 0;

                        for (int i = 0; i < acoustic.getCurrentSize(); i++) {
                            if (acoustic.getItemByIndex(i).getTrack_popularity() > maxAcoustic) {
                                maxAcoustic = acoustic.getItemByIndex(i).getTrack_popularity();
                                indexAcoustic = i;
                            }
                        }

                        roadTrip.add(acoustic.getItemByIndex(indexAcoustic));
                        acoustic.remove(acoustic.getItemByIndex(indexAcoustic));
                    }
                }
                System.out.println("Number of tracks in the playlist: " + roadTrip.getCurrentSize());

                int totalDuration = 0;
                for (int index = 0; index < roadTrip.getCurrentSize(); index++) {
                    totalDuration += roadTrip.getItemByIndex(index).getTrack_duration();
                }
                System.out.println("Total duration of the playlist: " + totalDuration / 60 + " min " + totalDuration % 60 + " sec");

                int totalPopularity = 0;
                for (int index = 0; index < roadTrip.getCurrentSize(); index++) {
                    totalPopularity += roadTrip.getItemByIndex(index).getTrack_popularity();
                }
                System.out.println("Average popularity of the playlist: " + (totalPopularity / roadTrip.getCurrentSize()));
                roadTrip.displayItems();
            }
            else{
                System.out.println("Invalid option!");
            }

            acoustic.clear();
            instrumental.clear();
            rock.clear();
            rap.clear();
            jazz.clear();
            pop.clear();
            music.clear();
            FileIO.readFile(acoustic,instrumental,rock,rap,jazz,pop,music);

        }
    }
}
