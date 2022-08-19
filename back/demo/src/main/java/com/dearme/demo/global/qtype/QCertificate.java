package com.dearme.demo.global.qtype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.dearme.demo.domain.user.entity.Certificate;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCertificate is a Querydsl query type for Certificate
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCertificate extends EntityPathBase<Certificate> {

    private static final long serialVersionUID = -538101415L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCertificate certificate = new QCertificate("certificate");

    public final StringPath contents = createString("contents");

    public final QCounselorProfile counselorProfile;

    //inherited

    public final NumberPath<Long> id = createNumber("id", Long.class);


    public QCertificate(String variable) {
        this(Certificate.class, forVariable(variable), INITS);
    }

    public QCertificate(Path<? extends Certificate> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCertificate(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCertificate(PathMetadata metadata, PathInits inits) {
        this(Certificate.class, metadata, inits);
    }

    public QCertificate(Class<? extends Certificate> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.counselorProfile = inits.isInitialized("counselorProfile") ? new QCounselorProfile(forProperty("counselorProfile"), inits.get("counselorProfile")) : null;
    }

}

