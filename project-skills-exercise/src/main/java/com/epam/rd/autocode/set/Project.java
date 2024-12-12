package com.epam.rd.autocode.set;

import java.util.*;

public class Project {
	private List<Role>roles;
	private List<Entry>projectEntries;
	private List<Entry>teamEntries;

	private static class Entry {
		private Level level;
		private Skill skill;

		@Override
		public int hashCode() {
			return Objects.hash(level, skill);
		}
		@Override
		public boolean equals(Object obj) {
			if(this == obj){
				return true;
			}
			if(obj == null || getClass() != obj.getClass()){
				return false;
			}
			Entry entry = (Entry) obj;
			return level == entry.level && skill == entry.skill;
		}

	}


	public Project(Role... roles) {
		this.roles = new ArrayList<>();
		this.projectEntries = new ArrayList<>();
		this.teamEntries = new ArrayList<>();
		if(roles == null){
			throw  new NullPointerException();
		}
        this.roles.addAll(Arrays.asList(roles));
	}

	public int getConformity(Set<Member> team) {
		for (Role role:this.roles ){
			for (Skill s:role.getSkills()) {
				Entry entry=new Entry();
				entry.level=role.getLevel();
				entry.skill =s;
				projectEntries.add(entry);
			}
		}

		for (Member member:team){
			for (Skill s:member.getSkills()) {
				Entry entry=new Entry();
				entry.level=member.getLevel();
				entry.skill =s;
				teamEntries.add(entry);
			}
		}
		int originalSize=this.projectEntries.size();
		Iterator <Entry>it=projectEntries.iterator();
		while (it.hasNext()){
			Entry curProjEntry=it.next();
			Iterator<Entry>teamIt=teamEntries.iterator();
			while (teamIt.hasNext()){
				Entry curTeamEntry=teamIt.next();
				if(curProjEntry.equals(curTeamEntry)){
					it.remove();
					teamIt.remove();
					break;
				}
			}
		}
		int currentProjSize=this.projectEntries.size();
		return (originalSize-currentProjSize)*100/originalSize;
	}
	public List<Role> getRoles(){
		return this.roles;
	}

}
