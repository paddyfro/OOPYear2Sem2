package FileIOCharacterStream;

public class Song 
{
	private String name, artist;
	private float runningTime;
		
	/******************** Constructors ********************/
	
	public Song(String name, String artist, float runningTime) {
		super();
		this.name = name;
		this.artist = artist;
		this.runningTime = runningTime;
	}

	/******************** Getters & Setters ********************/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public float getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(float runningTime) {
		this.runningTime = runningTime;
	}

	/******************** Other ********************/
	@Override
	public String toString() {
		return "Song [name=" + name + ", artist=" + artist + ", runningTime=" + runningTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(runningTime);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(runningTime) != Float.floatToIntBits(other.runningTime))
			return false;
		return true;
	}

	/******************** Serialization ********************/
	
	public String toXML()
	{
		return "<name>" + this.name + "</name>" 
		+ "<artist>" + this.artist + "</artist>"
		+ "<trackcount>" + this.runningTime + "</trackcount>";
	}
	
	public String toCSV()
	{
		return this.name + "," 
				+ this.artist + ","
					+ this.runningTime;
	}
	
	public String toHTMLTableData()
	{
		return "<td>" + this.name +"</td>"
				+ "<td>" + this.artist +"</td>"
				+ "<td>" + this.runningTime +"</td>";
	}
	
	
	
	
}
