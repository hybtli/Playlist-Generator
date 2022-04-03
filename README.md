# Playlist-Generator

Assume that, there are 5 types of playlists in this generator, and the minimum duration of a
playlist changes according to its type. The types include:

      [1] Sleeping → 45 minutes
      [2] Workout → 1 hours
      [3] Dining → 1.5 hour
      [4] Meditation → 2 hours
      [5] Road Trip → 3 hours
      
      
The playlist duration is set according to the selected type, at the beginning. Then, the playlist
is filled with tracks from 6 different genres:

      [1] Acoustic
      [2] Instrumental
      [3] Rock
      [4] Rap
      [5] Jazz
      [6] Pop
      
      
Until the playlist is ready, the generator repeatedly selects the most popular track from the
most suitable genre. Each category keeps the IDs of suitable genres in a list that is sorted by
suitability:

      [1] Sleeping → [2, 1, 5]
      [2] Workout → [4, 3, 6]
      [3] Dining → [5, 1, 2]
      [4] Meditation → [2, 1, 5]
      [5] Road Trip → [3, 6, 1]
      
For example, the most suitable genre is 4 (Rap) for a Workout playlist. Then, 3 (Rock) and 6
(Pop). Each track can only be added to a playlist once. Therefore, the tracks added to the
playlist should be removed from the genre collection.

The tracks are listed in the “tracks.txt” file where each line is formed as:
      
      genre_id, track_id, track_duration, track_popularity

Track duration is given in seconds, and track popularity refers to the number of plays.

