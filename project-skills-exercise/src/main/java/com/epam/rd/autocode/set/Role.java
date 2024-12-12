package com.epam.rd.autocode.set;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class Role {

	private Level level;

	private Position position;

	private Set<Skill> skills;

	public Role(Position position, Level level, Skill... skills) {
		if(position==null || level==null | skills==null || skills.length==0){
			throw new IllegalArgumentException();
		}
		this.position=position;
		this.level=level;
		this.skills = EnumSet.noneOf(Skill.class);
        this.skills.addAll(Arrays.asList(skills));
	}

	public Set<Skill> getSkills() {
		return this.skills;
	}

	public Level getLevel() {
		return level;
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Role{" +
				"level=" + level +
				", position=" + position +
				", skills=" + skills +
				'}';
	}
}
