package at.gv.parlament.documentation.hermes.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RecordSource {
	@NonNull @Getter private String name;
	
	@Override
	public String toString() {
		return name;
	}
}
