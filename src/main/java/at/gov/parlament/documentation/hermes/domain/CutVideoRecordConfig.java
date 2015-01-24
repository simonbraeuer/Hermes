package at.gov.parlament.documentation.hermes.domain;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
public @Getter @RequiredArgsConstructor class CutVideoRecordConfig implements IRecordConfig {
	@NonNull private String inVideo;
	@NonNull private String outVideo;
	@NonNull private String startTime;
	@NonNull private String endTime;
}
