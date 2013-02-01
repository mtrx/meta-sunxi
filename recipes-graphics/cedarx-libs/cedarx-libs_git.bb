
SRC_URI = "git://github.com/linux-sunxi/cedarx-libs.git;protocol=git;branch=master \
          "

SRCREV = "${AUTOREV}"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "CLOSED"

S = "${WORKDIR}/git/libcedarv/linux-armhf/"

do_install_append() {
    install -m 0755 $(find ${S} -name '*.so') ${D}${libdir}/
}

FILES_${PN} = "${libdir}/*"

