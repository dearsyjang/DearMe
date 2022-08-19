package com.dearme.demo.global.qtype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.dearme.demo.domain.user.entity.*;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCounselorProfile is a Querydsl query type for CounselorProfile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCounselorProfile extends EntityPathBase<CounselorProfile> {

    private static final long serialVersionUID = -1819072209L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCounselorProfile counselorProfile = new QCounselorProfile("counselorProfile");


    public final ListPath<Career, QCareer> careers = this.<Career, QCareer>createList("careers", Career.class, QCareer.class, PathInits.DIRECT2);

    public final ListPath<Category, QCategory> categories = this.<Category, QCategory>createList("categories", Category.class, QCategory.class, PathInits.DIRECT2);

    public final ListPath<Certificate, QCertificate> certificates = this.<Certificate, QCertificate>createList("certificates", Certificate.class, QCertificate.class, PathInits.DIRECT2);

    public final QUser counselor;

    public final NumberPath<Long> counselorId = createNumber("counselorId", Long.class);

    //inherited

    public final ListPath<Document, QDocument> documents = this.<Document, QDocument>createList("documents", Document.class, QDocument.class, PathInits.DIRECT2);

    public final StringPath introduce = createString("introduce");

    public final NumberPath<Long> price = createNumber("price", Long.class);

    public final NumberPath<Long> reviewcnt = createNumber("reviewcnt", Long.class);

    public final NumberPath<Long> reviewvalue = createNumber("reviewvalue", Long.class);

    //inherited

    public QCounselorProfile(String variable) {
        this(CounselorProfile.class, forVariable(variable), INITS);
    }

    public QCounselorProfile(Path<? extends CounselorProfile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCounselorProfile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCounselorProfile(PathMetadata metadata, PathInits inits) {
        this(CounselorProfile.class, metadata, inits);
    }

    public QCounselorProfile(Class<? extends CounselorProfile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.counselor = inits.isInitialized("counselor") ? new QUser(forProperty("counselor"), inits.get("counselor")) : null;
    }

}

