package com.epam.rd.autocode.set;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Member {
	
	private String name;
	
	private Level level;
	
	private Set<Skill> skills;

	public Member(String name, Level level, Skill... skills) {
		if(name == null || level==null || skills==null || skills.length==0){
			throw new IllegalArgumentException();
		}
		this.name=name;
		this.level=level;
		this.skills= EnumSet.noneOf(Skill.class);
        this.skills.addAll(Arrays.asList(skills));
	}

	public String getName() {
		return this.name;
	}

	public Level getLevel() {
		return this.level;
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	@Override
	public String toString() {
		return this.name+":"+this.level+this.skills;
	}
}

