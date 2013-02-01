
SRC_URI = "git://github.com/linux-sunxi/mali-libs.git;protocol=git;branch=master \
          "

SRCREV = "${AUTOREV}"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

LICENSE = "CLOSED"

ABI = "armhf"
MALI = "r3p0"
S = "${WORKDIR}/git/mali-libs/lib/$MALI/$ABI/"

do_install_append() {
	local libtype="x11" # or framebuffer
	local x= y=
	for x in x11 framebuffer; do
		mkdir -p "${D}/${libdir}/$x"
		for y in "${S}/$x/"*.so*; do
			cp -a "$y" "${D}/${libdir}/$x/"
			[ $x != $libtype ] ||
				ln -snf "${y#$S/}" "$rootfs/lib/"
		done
	done
}

FILES_${PN} = "${libdir}/*"

