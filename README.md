# Music Playlist Manager (Doubly Linked List)

A console-based **Music Playlist Manager** written in Java that implements a custom **Doubly Linked List** from scratch without using built-in Java collection classes (`java.util.LinkedList`).

Developed as a Second Year Computer Engineering **Data Structures (26CMPC32)** microproject at **Vivekanand Education Society's Institute of Technology (VESIT)**, Mumbai.

---

## Features & Supported Operations

1. **Add Song (`addSong`)** – Appends a new song (`songid`, `Title`, `Artist`) to the end (`tail`) of the playlist in $O(1)$ time (after duplicate ID check).
2. **Insert Song at Position (`insertSong`)** – Inserts a song at any valid 1-based position (`1` to `size + 1`) by updating `prev` and `next` node pointers.
3. **Delete Song (`deleteSong`)** – Searches for a song by ID, updates the `current` pointer safely if the active song is deleted, and unlinks the node.
4. **Display Playlist (`displayPlayList`)** – Traverses from `head` to `tail` and prints all songs along with the total song count.
5. **Search Song (`searchSong`)** – Performs a linear traversal by Song ID and displays song details if found.
6. **Play Next Song (`playNext`)** – Advances the `current` pointer forward (`current.next`) with end-of-playlist boundary handling.
7. **Play Previous Song (`playPrevious`)** – Moves the `current` pointer backward (`current.prev`) with start-of-playlist boundary handling.
8. **Input & State Checks (`isDuplicate`)** – Rejects duplicate Song IDs, invalid insertion positions, and handles empty-playlist operations without crashing.

---

## Data Structure Design

- **`Song` (Node Class):** Stores `int songid`, `String Title`, `String Artist`, and two self-referential pointers (`Song prev`, `Song next`).
- **`Playlist` (Doubly Linked List Class):** Maintains `head`, `tail`, `current`, and `size` to allow $O(1)$ tail appends and bidirectional (`next`/`previous`) navigation without shifting elements.

---

## Prerequisites

- **Java Development Kit (JDK 8 or higher)** installed and added to system `PATH`.

---

## How to Compile and Run

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/deepeshbind13/Music-Playlist-Manager.git](https://github.com/deepeshbind13/Music-Playlist-Manager.git)
   cd Music-Playlist-Manager
   ```

2. **Compile the Java program:**
   ```bash
   javac MusicPlaylistManager.java
   ```

3. **Run the application:**
   ```bash
   java MusicPlaylistManager
   ```

---

## Sample Console Menu & Input

```text
===== MUSIC PLAYLIST MANAGER =====
1. Add Song
2. Insert Song at Position
3. Delete Song
4. Display Playlist
5. Search Song
6. Play Next Song
7. Play Previous Song
8. Exit
Enter your choice: 1
Enter Song ID: 101
Enter Song Title: As It Was
Enter Artist Name: Harry Styles
As It Was successfully added!
```
