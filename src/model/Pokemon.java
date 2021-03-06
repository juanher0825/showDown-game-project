package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import javafx.scene.image.Image;

@SuppressWarnings("serial")
public class Pokemon implements Serializable,  Comparable<Pokemon>{
		
	    //Attributes
	    private String name;
		private Image img;
		private Type k;
		private double baseLife;
		private double basicAtack;
		private double basicDefense;
		private double especialAtack;
		private double especialDefense;
		private double speed;
		
		private Pokemon next;
		private Pokemon prev;
		private Pokemon left;
		private Pokemon right;
		
		//Relations
		private Skill[] skills;
		
		//Methods	
		public Pokemon(String name, Image champPic, Type k, double baseLife, double basicAtack, double basicDefense,
				double especialAtack, double especialDefense, double speed) {
			super();
			this.name = name;
			this.img = champPic;
			this.k = k;
			this.baseLife = baseLife;
			this.basicAtack = basicAtack;
			this.basicDefense = basicDefense;
			this.especialAtack = especialAtack;
			this.especialDefense = especialDefense;
			this.speed = speed;
			skills= new Skill[4];
		}
		
		
		   public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public Image getImg() {
			return img;
		}


		public void setChampPic(Image champPic) {
			this.img = champPic;
		}


		public Type getK() {
			return k;
		}


		public void setK(Type k) {
			this.k = k;
		}


		public double getBaseLife() {
			return baseLife;
		}


		public void setBaseLife(double baseLife) {
			this.baseLife = baseLife;
		}


		public double getBasicAtack() {
			return basicAtack;
		}


		public void setBasicAtack(double basicAtack) {
			this.basicAtack = basicAtack;
		}


		public double getBasicDefense() {
			return basicDefense;
		}


		public void setBasicDefense(double basicDefense) {
			this.basicDefense = basicDefense;
		}


		public double getEspecialAtack() {
			return especialAtack;
		}


		public void setEspecialAtack(double especialAtack) {
			this.especialAtack = especialAtack;
		}


		public double getEspecialDefense() {
			return especialDefense;
		}


		public void setEspecialDefense(double especialDefense) {
			this.especialDefense = especialDefense;
		}


		public double getSpeed() {
			return speed;
		}


		public void setSpeed(double speed) {
			this.speed = speed;
		}


		public Skill[] getSkills() {
			return skills;
		}


		public void setSkills(Skill[] skills) {
			this.skills = skills;
		}

		public Pokemon getNextPokemon() {
			return next;
		}


		public void setNextPokemon(Pokemon next) {
			this.next = next;
		}


		public Pokemon getPrevPokemon() {
			return prev;
		}


		public void setPrevPokemon(Pokemon prev) {
			this.prev = prev;
		}

		public Pokemon getLeft() {
			return left;
		}


		public void setLeft(Pokemon left) {
			this.left = left;
		}


		public Pokemon getRight() {
			return right;
		}


		public void setRight(Pokemon right) {
			this.right = right;
		}
		
		
		public void assignSkills() throws IOException
		    {   
		    	for(int i=0;i<4;i++) {
		    		int numero = (int) (Math.random() * 1) + 1;  	
		    		File f= new File("skills/"+k+"/"+numero);
		        	FileReader fr= new FileReader(f);
		        	BufferedReader br= new BufferedReader(fr);
		        	String line=br.readLine();
		        	while(line !=null) {
		        	    	String[] parts=line.split(";");
		        	    	String nameAtack=parts[0];
		        	    	String description=parts[1];
		        	    	double manaCost=Double.parseDouble(parts[2]);
		        	    	Skill s= new Skill(nameAtack, description, manaCost);
		        	    	skills[i]=s;
		        	    	line=br.readLine();
		        	}
		        	br.close();
		        	fr.close();
		        }

		    }


		@Override
		public int compareTo(Pokemon p) {
			int comparation;
			
			if(name.compareTo(p.name)<0) {
				comparation = -1;
			}else if(name.compareTo(p.name)>0) {
				comparation =1;
			}else {
				comparation = 0;
			}
			return comparation;
		}
		
}
