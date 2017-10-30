package service.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import domain.Entity;
import domain.entityImpl.Enrollee;
import domain.entityImpl.ExamScope;
import domain.entityImpl.Specialty;
import domain.entityImpl.Subject;
import domain.entityImpl.University;
import service.Service;
import service.serviceImpl.EnrolleeService;
import service.serviceImpl.ExamScopeService;
import service.serviceImpl.SpecialtyService;
import service.serviceImpl.SubjectService;
import service.serviceImpl.UniversityService;

public class ServiceFacroty {
	
	@SuppressWarnings("rawtypes")
	private static final Map<Class<? extends Entity>, Service> SERVICES = new ConcurrentHashMap<Class<? extends Entity>,Service>();

	static {
		SERVICES.put(Enrollee.class, new EnrolleeService());
		SERVICES.put(ExamScope.class, new ExamScopeService());
		SERVICES.put(Specialty.class, new SpecialtyService());
		SERVICES.put(Subject.class, new SubjectService());
		SERVICES.put(University.class, new UniversityService());
	}	

	public static EnrolleeService getEnrolleeService() {
		return (EnrolleeService) SERVICES.get(Enrollee.class);
	}

	public static ExamScopeService getExamScopeService() {
		return (ExamScopeService) SERVICES.get(ExamScope.class);
	}

	public static SpecialtyService getSpecialtyService() {
		return (SpecialtyService) SERVICES.get(Specialty.class);
	}

	public static SubjectService getSubjectService() {
		return (SubjectService) SERVICES.get(Subject.class);
	}

	public static UniversityService getUniversityService() {
		return (UniversityService) SERVICES.get(University.class);
	}
	
}
