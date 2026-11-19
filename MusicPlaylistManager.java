import java.util.*;

class Song {
    int songid;
    String Title;
    String Artist;
    Song prev;
    Song next;

    Song(int songid, String Title, String Artist) {
        this.songid = songid;
        this.Title = Title;
        this.Artist = Artist;
        this.prev = null;
        this.next = null;
    }
}

class Playlist {
    Song head;
    Song tail;
    Song current;
    int size;

    Playlist() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    // Check whether song ID already exists
    boolean isDuplicate(int songid) {
        Song temp = head;
        while (temp != null) {
            if (temp.songid == songid) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    void addSong(int songid, String Title, String Artist) {
        if (isDuplicate(songid)) {
            System.out.println("Song ID already exists!");
            return;
        }

        Song newSong = new Song(songid, Title, Artist);
        if (head == null) {
            head = newSong;
            tail = newSong;
            current = newSong;
        } else {
            newSong.prev = tail;
            tail.next = newSong;
            tail = newSong;
        }
        size++;
        System.out.println(Title + " successfully added!");
    }

    void displayPlayList() {
        if (head == null) {
            System.out.println("Playlist is Empty!");
            return;
        }

        Song temp = head;
        while (temp != null) {
            System.out.println("SongID: " + temp.songid);
            System.out.println("Song Name: " + temp.Title);
            System.out.println("Artist: " + temp.Artist);
            temp = temp.next;
        }
        System.out.println("Total Songs: " + size);
    }

    void insertSong(int songid, String Title, String Artist, int position) {
        // Check whether position is valid
        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }

        // Prevent duplicate song IDs
        if (isDuplicate(songid)) {
            System.out.println("Song ID already exists!");
            return;
        }

        // Inserting at the beginning
        if (position == 1) {
            Song newSong = new Song(songid, Title, Artist);
            if (head == null) {
                head = newSong;
                tail = newSong;
                current = newSong;
            } else {
                newSong.next = head;
                head.prev = newSong;
                head = newSong;
            }
            size++;
            System.out.println("Song inserted successfully!");
            return;
        }

        // Inserting at the end
        if (position == size + 1) {
            addSong(songid, Title, Artist);
            return;
        }

        // Inserting in the middle
        Song temp = head;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        Song newSong = new Song(songid, Title, Artist);
        newSong.prev = temp.prev;
        newSong.next = temp;
        temp.prev.next = newSong;
        temp.prev = newSong;
        size++;
        System.out.println("Song inserted successfully!");
    }

    void deleteSong(int songid) {
        if (head == null) {
            System.out.println("Playlist is empty!");
            return;
        }

        Song temp = head;
        // Search for the song by ID
        while (temp != null && temp.songid != songid) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Song ID not found!");
            return;
        }

        // If the song being deleted is current,
        // select the next song if available,
        // otherwise select the previous song.
        if (current == temp) {
            if (temp.next != null) {
                current = temp.next;
            } else {
                current = temp.prev;
            }
        }

        // If the song is the first node
        if (temp == head) {
            head = temp.next;
        } else {
            temp.prev.next = temp.next;
        }

        // If the song is the last node
        if (temp == tail) {
            tail = temp.prev;
        } else {
            temp.next.prev = temp.prev;
        }

        size--;

        // If the playlist becomes empty
        if (size == 0) {
            head = null;
            tail = null;
            current = null;
        }

        System.out.println("Song deleted successfully!");
    }

    void searchSong(int songid) {
        Song temp = head;
        while (temp != null) {
            if (temp.songid == songid) {
                System.out.println("Song found!");
                System.out.println("Song ID: " + temp.songid);
                System.out.println("Title: " + temp.Title);
                System.out.println("Artist: " + temp.Artist);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Song not found!");
    }

    void playNext() {
        if (current == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        if (current.next == null) {
            System.out.println("This is the last song!");
            return;
        }
        current = current.next;
        System.out.println("Now playing: " + current.Title);
    }

    void playPrevious() {
        if (current == null) {
            System.out.println("Playlist is empty!");
            return;
        }
        if (current.prev == null) {
            System.out.println("This is the first song!");
            return;
        }
        current = current.prev;
        System.out.println("Now playing: " + current.Title);
    }
}

public class MusicPlaylistManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Playlist playlist = new Playlist();
        int choice;

        do {
            System.out.println("\n===== MUSIC PLAYLIST MANAGER =====");
            System.out.println("1. Add Song");
            System.out.println("2. Insert Song at Position");
            System.out.println("3. Delete Song");
            System.out.println("4. Display Playlist");
            System.out.println("5. Search Song");
            System.out.println("6. Play Next Song");
            System.out.println("7. Play Previous Song");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Song ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Song Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    String artist = sc.nextLine();
                    playlist.addSong(id, title, artist);
                    break;

                case 2:
                    System.out.print("Enter Song ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Song Title: ");
                    title = sc.nextLine();
                    System.out.print("Enter Artist Name: ");
                    artist = sc.nextLine();
                    System.out.print("Enter Position (starting from 1): ");
                    int position = sc.nextInt();
                    playlist.insertSong(id, title, artist, position);
                    break;

                case 3:
                    System.out.print("Enter Song ID to delete: ");
                    id = sc.nextInt();
                    playlist.deleteSong(id);
                    break;

                case 4:
                    playlist.displayPlayList();
                    break;

                case 5:
                    System.out.print("Enter Song ID to search: ");
                    id = sc.nextInt();
                    playlist.searchSong(id);
                    break;

                case 6:
                    playlist.playNext();
                    break;

                case 7:
                    playlist.playPrevious();
                    break;

                case 8:
                    System.out.println("Exiting Music Playlist Manager...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}