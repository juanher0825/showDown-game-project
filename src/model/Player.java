package model;

import java.io.Serializable;

public class Player implements Serializable{
	
	//Attributes
	private String name;
    private String profilePicture;
    
    private Player next;
    private Player prev;
    

	//Relations
    private Pokemon[] team;
    
	public Player(String name, String profilePicture) 
	{
		this.name = name;
		this.profilePicture = profilePicture;
		
		team= new Pokemon[6];
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}
    
	public String getProfilePicture() 
	{
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) 
	{
		this.profilePicture = profilePicture;
	}
	public Pokemon[] getPokemons() 
	{
		return team;
	}

	public void setPokemons(Pokemon[] champions)
	{
		this.team = champions;
	}
	
    public Player getNextPlayer() {
		return next;
	}

	public void setNextPlayer(Player next) {
		this.next = next;
	}

	public Player getPrevPlayer() {
		return prev;
	}

	public void setPrevPlayer(Player prev) {
		this.prev = prev;
	}
	
	public void addPokemon(String name, String champPic, Type k, double baseLife, double basicAtack, double basicDefense, double especialAtack, double especialDefense, double speed) {
		Pokemon p= new Pokemon(name, champPic, k, baseLife, basicAtack, basicDefense, especialAtack, especialDefense, speed);
		for(int i=0; i<team.length;i++) {
			if(team[i]==null) {
				team[i]=p;
				i=team.length;
			}
		}
	}
   	
}
