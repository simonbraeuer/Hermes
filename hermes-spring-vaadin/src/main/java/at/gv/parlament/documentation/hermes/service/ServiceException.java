package at.gv.parlament.documentation.hermes.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SuppressWarnings("serial")
public class ServiceException extends Exception {
	@NonNull private IServiceExceptionContent content;

	@Override
	public String getMessage() {
		return content.getMessage();
	}
}
